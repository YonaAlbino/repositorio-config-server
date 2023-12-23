package com.yonathan.cities.service;

import com.yonathan.cities.dto.CityDto;

import java.util.List;

public interface ICityService {

    public CityDto getCityByNameAndCountry(String name, String  country);
}
