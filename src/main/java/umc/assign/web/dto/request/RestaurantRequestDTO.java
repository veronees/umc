package umc.assign.web.dto.request;

import lombok.Getter;
import umc.assign.domain.enums.RestaurantType;

@Getter
public class RestaurantRequestDTO {

    private RestaurantType restaurantType;
    private String name;
}
