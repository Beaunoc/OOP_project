package utils;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DomainConstraint {
    String type();
    boolean mutable();
    boolean optional();
    int length() default 0;
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}
