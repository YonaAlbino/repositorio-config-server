package com.yonathan.cities.service;

import com.yonathan.cities.dto.CityDto;
import com.yonathan.cities.model.City;
import com.yonathan.cities.repository.IHotelRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CityService implements ICityService{

    @Autowired
    private IHotelRepository hotelRepo;

    List<City> cityList = new ArrayList<>();



    @Override
    @CircuitBreaker(name = "hotels-service", fallbackMethod = "fallBackGetHotels")
    @Retry(name = "hotels-service")
    public CityDto getCityByNameAndCountry(String name, String country) {

        CityDto cityDto = new CityDto();

        loadCitys(cityList);

        City city = findCity(name, country);

        cityDto.setCity_id(city.getCity_id());
        cityDto.setName(city.getName());
        cityDto.setContinent(city.getContinent());
        cityDto.setCountry(city.getCountry());
        cityDto.setState(city.getState());
        cityDto.setHotelsList(hotelRepo.getHotelsByCityId(city.getCity_id()));



        return cityDto;

    }

    private void arrojarException() {
        throw new IllegalArgumentException("Prueba circuit breaker");
    }

    private CityDto fallBackGetHotels(Throwable throwable){
        return new CityDto();
    }

    private void loadCitys(List<City> cityList){
        cityList.add(new City(1L, "Buenos aires", "America","Argentina", "Misiones"));
        cityList.add(new City(2L, "Paris", "Europe", "France", "Ile-de-France"));
        cityList.add(new City(3L, "Tokyo", "Asia", "Japan", "Tokyo"));
        cityList.add(new City(4L, "Cape Town", "Africa", "South Africa", "Western Cape"));
        cityList.add(new City(5L, "Sydney", "Oceania", "Australia", "New South Wales"));
        cityList.add(new City(6L, "New York", "North America", "United States", "New York"));
        cityList.add(new City(7L, "Mumbai", "Asia", "India", "Maharashtra"));
        cityList.add(new City(8L, "Rome", "Europe", "Italy", "Lazio"));
        cityList.add(new City(9L, "Cairo", "Africa", "Egypt", "Cairo Governorate"));
        cityList.add(new City(10L, "Seoul", "Asia", "South Korea", "Seoul"));
    }

    private City findCity(String name, String country){

        for (City city:cityList)
            if (city.getName().equals(name)) if (city.getCountry().equals(country))
                return city;
        return null;
    }
}
