package com.restapiproject.hotelManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restapiproject.hotelManagement.exception.ResourceNotFoundException;
import com.restapiproject.hotelManagement.model.Hotel;
import com.restapiproject.hotelManagement.repository.HotelDao;

@Service
public class HotelServiceImpl implements HotelService{
 
	private final HotelDao hotelDao;
	public HotelServiceImpl(HotelDao hotelDao) {
		super();
		this.hotelDao = hotelDao;
	}
	@Override
	public Hotel createHotel(Hotel hotel) {			
		return hotelDao.save(hotel);
	}

	@Override
	public Hotel getHotelById(Long id) {
		return hotelDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id : "+id));
	}
	@Override
	public List<Hotel> getAllHotels() {
		return hotelDao.findAll();
	}
	@Override
	public Hotel updateHotel(Long id, Hotel hotel) {
		Hotel existing = getHotelById(id);
		existing.setName(hotel.getName());
		existing.setAddress(hotel.getAddress());
		existing.setTotal_rooms(hotel.getTotal_rooms());
		existing.setAvailable_rooms(hotel.getAvailable_rooms());
		existing.setPrice_per_night(hotel.getPrice_per_night());
		int rows = hotelDao.update(existing);
		if(rows<=0) throw new RuntimeException("Updation failed for id: "+ id);
		return existing;
	}
	@Override
	public void deleteHotel(Long id) {
		getHotelById(id);
		int rows = hotelDao.deleteById(id);
		if (rows <= 0)
			throw new RuntimeException("delete failed for hotel id " + id);
	}
	@Override
	public List<Hotel> searchByName(String name) {
		if(name==null) throw new ResourceNotFoundException();
		return hotelDao.searchByName(name);
	}
}
 