package com.restapiproject.hotelManagement.auth;

import java.io.IOException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
 
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
	// Secu
		
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AppUserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			                        HttpServletResponse response,
			                        FilterChain filterChain)
			                        throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null && authHeader.startsWith("Bearer ")) {			// Bearer sdshjdmsdns
			String token = authHeader.substring(7); // extract only token after removing Bearer
			if(jwtUtil.validateToken(token)) {
				String username = jwtUtil.getUserNameFromToken(token);
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication =
						          new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				// session id, client IP....
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);	// request is authenticated				              
			}
		}
		filterChain.doFilter(request, response);
	}
}
