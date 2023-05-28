package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Dooby Kim
 * @Date 2023/5/28 7:02 下午
 * @Version 1.0
 * @Desc 用来标记线程不安全的类或写法
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface UnSafe {
    String value() default "";
}
