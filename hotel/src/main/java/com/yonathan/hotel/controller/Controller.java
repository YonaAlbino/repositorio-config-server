package com.yonathan.hotel.controller;

import com.yonathan.hotel.HotelService.IHotelService;
import com.yonathan.hotel.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IHotelService hotelService;

    @GetMapping("/hotels/{citi_id}")
    public List<Hotel> getHotelsListByCitiId(@PathVariable Long citi_id){
        return hotelService.getHotelsByCityId(citi_id);
    }
}
