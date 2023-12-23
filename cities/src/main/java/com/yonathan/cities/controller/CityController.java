package com.yonathan.cities.controller;

import com.yonathan.cities.dto.CityDto;
import com.yonathan.cities.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping("/cityDto")
    public CityDto getCityDto(@RequestParam String name, @RequestParam String country){
        return cityService.getCityByNameAndCountry(name, country);
    }
}
