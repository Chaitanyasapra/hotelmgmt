package com.restapiproject.hotelManagement.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.restapiproject.hotelManagement.model.Hotel;
import com.restapiproject.hotelManagement.util.HotelMapper;

@Repository //it is going to mark this class as dao component. Spring detects dependency injection automatically

public class HotelDaoImpl implements HotelDao{

	private final JdbcTemplate jdbcTemplate;
	
	public HotelDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Hotel save(Hotel hotel) {
		String sql = "INSERT INTO hotels(name, address, total_rooms, "
				+ "available_rooms, price_per_night)"
				+ "VALUES (?, ?, ?, ?, ? )";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(connection ->{
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, hotel.getName());
			ps.setString(2, hotel.getAddress());
			ps.setInt(3, hotel.getTotal_rooms());
			ps.setInt(4, hotel.getAvailable_rooms());
			ps.setBigDecimal(5, hotel.getPrice_per_night());
			
			return ps;
			
		}, keyHolder);
		
		if(keyHolder.getKey()!= null) {
			hotel.setId(keyHolder.getKey().longValue());
		}
		return hotel;
	}
	
	//Read by id
	
	@Override
	public Optional<Hotel> findById(Long id){
		String sql = "select * from hotels where id = ?";
		List<Hotel> list = jdbcTemplate.query(sql, new HotelMapper(), id);
		
		return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
	}
	
	//Read all
	@Override
	public List<Hotel> findAll(){
		String sql = "SELECT * FROM hotels";
		return jdbcTemplate.query(sql, new HotelMapper());
	}
	
	//Update
	@Override
	public int update(Hotel hotel) {
		String sql = "UPDATE hotels SET name = ?, address = ?, total_rooms = ?, available_rooms = ?, price_per_night = ? WHERE id = ?";
		return jdbcTemplate.update(sql, hotel.getName(), hotel.getAddress(), hotel.getTotal_rooms(), hotel.getAvailable_rooms(), hotel.getPrice_per_night(), hotel.getId());
	}
	
	//delete
	@Override
	public int deleteById(Long id) {
		String sql = "DELETE FROM hotels WHERE id = ?";
		
		
		return jdbcTemplate.update(sql, id);
	}
	
	@Override
	public List<Hotel> searchByName(String name){
		
		String sql = "SELECT * FROM hotels WHERE LOWER(name) LIKE ?;";
		String pattern= "%"+name.toLowerCase()+"%";
		List<Hotel> list = jdbcTemplate.query(sql, new HotelMapper(), pattern);
		
		return list;
	}
	
}
