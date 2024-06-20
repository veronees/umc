package umc.assign.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.assign.validation.validator.AlreadyChallengeMissionValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AlreadyChallengeMissionValidator.class)
@Target( {ElementType.TYPE_USE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AlreadyChallengeMission {

    String message() default "이미 도전중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String memberIdField();
    String missionIdField();
}