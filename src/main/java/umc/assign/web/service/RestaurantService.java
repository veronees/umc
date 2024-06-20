package umc.assign.web.service;

import umc.assign.web.dto.request.RestaurantRequestDTO;

public interface RestaurantService {

    public void saveRestaurant(Long regionId, RestaurantRequestDTO restaurantRequestDTO);
}
