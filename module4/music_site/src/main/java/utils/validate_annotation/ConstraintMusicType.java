package utils.validate_annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = ValidateMusicType.class)
public @interface ConstraintMusicType {
    String message() default "MusicType không đúng định dạng";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
