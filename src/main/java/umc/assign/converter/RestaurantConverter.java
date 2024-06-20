package umc.assign.converter;

import umc.assign.domain.Restaurant;
import umc.assign.web.dto.request.RestaurantRequestDTO;

public class RestaurantConverter {

    public static Restaurant toRestaurant(RestaurantRequestDTO request) {
        return Restaurant.builder()
                .restaurantType(request.getRestaurantType())
                .name(request.getName())
                .build();
    }
}