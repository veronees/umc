package umc.assign.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import umc.assign.validation.annotation.NotExistRestaurant;

@Getter
@Setter
public class ReviewRequestDTO {
    private String content;
    @NotExistRestaurant
    private Long restaurantId;
}
