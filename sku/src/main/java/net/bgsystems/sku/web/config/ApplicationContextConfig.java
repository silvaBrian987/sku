package net.bgsystems.sku.web.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.bgsystems.sku.util.jackson.ObjectMapperProvider;
import net.bgsystems.sku.web.filter.SessionInterceptor;
import net.bgsystems.util.web.User;


@Configuration
@EnableWebMvc
@ComponentScan({"net.bgsystems.sku"})
public class ApplicationContextConfig implements WebMvcConfigurer {

	@Bean
	@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public User sessionUser() {
		return new User();
	}

	@Bean
	public SessionInterceptor sessionInterceptor() {
		return new SessionInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor());
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(ObjectMapperProvider.createDefaultMapper());
		converters.add(converter);
		WebMvcConfigurer.super.configureMessageConverters(converters);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		WebMvcConfigurer.super.addFormatters(registry);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
	}
}
