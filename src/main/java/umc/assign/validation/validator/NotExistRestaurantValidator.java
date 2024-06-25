package umc.assign.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.assign.validation.annotation.NotExistRestaurant;
import umc.assign.web.repository.RestaurantRepository;

@Component
@RequiredArgsConstructor
public class NotExistRestaurantValidator implements ConstraintValidator<NotExistRestaurant, Long> {

    private final RestaurantRepository restaurantRepository;

    @Override
    public void initialize(NotExistRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return restaurantRepository.existsById(value);
    }
}