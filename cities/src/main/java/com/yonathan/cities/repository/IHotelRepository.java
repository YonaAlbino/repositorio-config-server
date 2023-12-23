package com.yonathan.cities.repository;

import com.yonathan.cities.dto.CityDto;
import com.yonathan.cities.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
@FeignClient(name = "hotels-service")
public interface IHotelRepository {

    @GetMapping("/hotels/{citi_id}")
    public List<HotelDto> getHotelsByCityId(@PathVariable Long citi_id);
}
