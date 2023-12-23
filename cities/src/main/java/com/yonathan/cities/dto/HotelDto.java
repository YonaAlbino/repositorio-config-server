package com.yonathan.cities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

    private  Long id;
    private  String name;
    private int stars;
    private  Long citiId;
}
