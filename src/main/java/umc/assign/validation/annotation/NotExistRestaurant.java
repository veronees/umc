package umc.assign.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.assign.validation.validator.AlreadyChallengeMissionValidator;
import umc.assign.validation.validator.NotExistRestaurantValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotExistRestaurantValidator.class)
@Target( {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotExistRestaurant {
    String message() default "해당 식당을 찾을 수 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
