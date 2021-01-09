package cosmetic.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil {
    public static ApplicationContext ctx;

    @Autowired
    private void setApplicationContext(ApplicationContext context) {
        ctx = context;
    }
}
