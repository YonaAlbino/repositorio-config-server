package com.yonathan.hotel.HotelService;

import com.yonathan.hotel.model.Hotel;

import java.util.List;

public interface IHotelService {

    List<Hotel> getHotelsByCityId(Long id);
}
