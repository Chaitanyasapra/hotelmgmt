package com.restapiproject.hotelManagement.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HotelDto {
	
	//model -> represents a table- hotel
	//directly maps to the table by jdbc
	
	//dto: Data Transfer Object
	//used for communication between layers controller: service: client
	//used to validate user input without exposing internal db structure
	//makes your APIs independent of db changes
	//customize what data goes out, comes in-> createdAt
	
	//postman -> controller layer (Accepts hotel dto)-> validation happens
	
	private Long id;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotNull(message="Total rooms is required")
	@Min(value=1, message="total_rooms must be >= 1")
	private Integer total_rooms;
	
	@NotNull(message="Available rooms is required")
	@Min(value=0, message="total_rooms must be >= 0")
	private Integer available_rooms;
	
	@NotNull(message="price_per_night is required")
	@DecimalMin(value="0.0", message="total_rooms must be >= 0")
	private BigDecimal price_per_night;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTotal_rooms() {
		return total_rooms;
	}

	public void setTotal_rooms(Integer total_rooms) {
		this.total_rooms = total_rooms;
	}

	public Integer getAvailable_rooms() {
		return available_rooms;
	}

	public void setAvailable_rooms(Integer available_rooms) {
		this.available_rooms = available_rooms;
	}

	public BigDecimal getPrice_per_night() {
		return price_per_night;
	}

	public void setPrice_per_night(BigDecimal price_per_night) {
		this.price_per_night = price_per_night;
	}

	public HotelDto(Long id, @NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Address is required") String address,
			@NotNull(message = "Total rooms is required") @Min(value = 1, message = "total_rooms must be >= 1") Integer total_rooms,
			@NotNull(message = "Available rooms is required") @Min(value = 0, message = "total_rooms must be >= 0") Integer available_rooms,
			@NotNull(message = "price_per_night is required") @DecimalMin(value = "0.0", message = "total_rooms must be >= 0") BigDecimal price_per_night) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.total_rooms = total_rooms;
		this.available_rooms = available_rooms;
		this.price_per_night = price_per_night;
	}

	public HotelDto() {
		super();
	}
	
	
	
	

}
