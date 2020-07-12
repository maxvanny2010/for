package forum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * BootConfig.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/16/2020
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * Constructor.
     */
    public WebConfig() {
    }

    /**
     * Method to a view resolver.
     *
     * @return bean
     */
    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver bean =
                new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forum");
        registry.addViewController("/forum").setViewName("forum");
        registry.addViewController("/cabinet/user").setViewName("cabinet");
        registry.addViewController("/cabinet/admin").setViewName("cabinet");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("login");
        registry.addViewController("/registration").setViewName("registration");
    }
}
