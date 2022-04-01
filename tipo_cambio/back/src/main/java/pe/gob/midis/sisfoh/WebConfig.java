package pe.gob.midis.sisfoh;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer  {

	@Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
//                .allowedOrigins("http://192.168.83.205")
//        		.allowedOrigins("192.168.83.205")
//        .allowedOrigins("192.168.64.19")
        		.allowedOrigins("**")
                .allowedMethods("GET", "POST", "PATCH", "DELETE", "PUT", "OPTIONS")
                .allowedHeaders("*");
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");
	    registry.addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	
	
}
