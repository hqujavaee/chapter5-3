package cn.edu.hqu.cst.javaee.HuaMent.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("cn.edu.hqu.cst.javaee.HuaMent.controller")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}


    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
    	StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));         
    	return converter;     
    }
    
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		
		super.configureMessageConverters(converters);
		converters.add(responseBodyConverter());
	}
	

	
}
