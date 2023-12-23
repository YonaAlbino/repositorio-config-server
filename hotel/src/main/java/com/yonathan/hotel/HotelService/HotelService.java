package com.yonathan.hotel.HotelService;

import com.yonathan.hotel.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HotelService implements IHotelService{
    @Override
    public List<Hotel> getHotelsByCityId(Long CitiId) {

        List<Hotel> originHotelsList = new ArrayList<>();
        List<Hotel> editHotelsList = new ArrayList<>();

        loadHotelsList(originHotelsList);

        for (Hotel hotel:originHotelsList){

            if(hotel.getCitiId() == CitiId){
                editHotelsList.add(hotel);
            }
        }

        return editHotelsList;
    }

    public void loadHotelsList(List<Hotel> listHotels){
        listHotels.add(new Hotel(1l, "paradise", 5, 1L));
        listHotels.add(new Hotel(1L, "oceanview", 4, 2L));
        listHotels.add(new Hotel(3L, "luxury resort", 5, 3L));
        listHotels.add(new Hotel(4L, "cityscape inn", 3, 4L));
        listHotels.add(new Hotel(5L, "mountain retreat", 4, 5L));
        listHotels.add(new Hotel(5L, "historic mansion", 5, 5L));

    }
}
