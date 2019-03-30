package com.htp.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Locale;

//@EnableWebMvc  //<mvc:annotation-driven>
//@Configuration
//@ComponentScan(basePackages = {"com.htp"}) //<context:component-scan base-package=''>
public class MvcConfig /*extends WebMvcConfigurerAdapter*/ {
//
//    /**
//     * <mvc:resources mapping="/resources/**" location="/resources/" />
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//    }
//
//    /**
//     * bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//     */
//    @Bean
//    public InternalResourceViewResolver jspViewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setOrder(1);
//        viewResolver.setPrefix("/WEB-INF/view/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
//
//    /**
//     * <mvc:view-controller path="/about.html" view-name="/about/about"/>
//     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
//        registry.addViewController("/").setViewName("forward:/index.html");
//        registry.addViewController("/about.html").setViewName("/about/about");
//        registry.addViewController("/index.jsp").setViewName("/hello");
//
//        registry.addViewController("/").setViewName("/index");
//        registry.addViewController("/index.html").setViewName("/index");
//        registry.addViewController("/login.html").setViewName("/form/login");
//        registry.addViewController("/about.html").setViewName("/about/about");
//        registry.addViewController("/file.html").setViewName("/file/file");
//        registry.addViewController("/jdbc.html").setViewName("/jdbc/jdbc");
//        registry.addViewController("/email.html").setViewName("/email/email");
//        registry.addViewController("/rest.html").setViewName("/rest/rest");
//        registry.addViewController("/orm.html").setViewName("/orm/orm");
//        registry.addViewController("/jstl.html").setViewName("/jstl/jstl");
//        registry.addViewController("/scope.html").setViewName("/scope/scope");
//        registry.addViewController("/cookie.html").setViewName("/cookie/cookieView");
//        registry.addViewController("/security.html").setViewName("/security/security");
//        registry.addViewController("/security/admin.html").setViewName("/security/admin");
//
//        registry.addViewController("/angularIndex.html").setViewName("/angularjs/angularindex");
//        registry.addViewController("/angularjson.html").setViewName("/angularjs/angularjson");
//        registry.addViewController("/expressions.html").setViewName("/angularjs/expressions");
//        registry.addViewController("/ng-bind-model.html").setViewName("/angularjs/ng-bind-model");
//        registry.addViewController("/ng-class.html").setViewName("/angularjs/ng-class");
//        registry.addViewController("/ng-click-show.html").setViewName("/angularjs/ng-click-show");
//        registry.addViewController("/ng-if-switch.html").setViewName("/angularjs/ng-if-switch");
//        registry.addViewController("/ng-init.html").setViewName("/angularjs/ng-init");
//        registry.addViewController("/ng-repeat.html").setViewName("/angularjs/ng-repeat");
//        registry.addViewController("/two-way-binding.html").setViewName("/angularjs/two-way-binding");
//        registry.addViewController("/angularDI.html").setViewName("/angularjs/angularDI");
//        registry.addViewController("/ng-controller.html").setViewName("/angularjs/ng-controller");
//        registry.addViewController("/angularfilters.html").setViewName("/angularjs/filters");
//        registry.addViewController("/angularvalidation.html").setViewName("/angularjs/validation");
//        registry.addViewController("/angularrouting.html").setViewName("/angularjs/routing");
//        registry.addViewController("/angularhttpresource.html").setViewName("/angularjs/httpresource");
//        registry.addViewController("/customdirective.html").setViewName("/angularjs/customdirective");
//        registry.addViewController("/html5.html").setViewName("/html5/html5");
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(getJacksonHttpMessageConverter());
//    }
//
//    @Bean(name = "jacksonHttpMessageConverter")
//    public MappingJackson2HttpMessageConverter getJacksonHttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setPrettyPrint(true);
//        return converter;
//    }
//
//    /**
//     * <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
//     */
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver getMultipartResolver() {
//        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
//        cmr.setMaxUploadSize(1000000);
//        return cmr;
//    }
//
//    /**
//     * <bean id="localeResolver" class="org.springframework.web.servlet.i18n.CookieLocaleResolver">
//     */
//    @Bean(name = "localeResolver")
//    public CookieLocaleResolver getLocaleResolver() {
//        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
//        cookieLocaleResolver.setDefaultLocale(new Locale("ru"));
//        cookieLocaleResolver.setCookieMaxAge(100000);
//        return cookieLocaleResolver;
//    }
//
//    /**
//     * <bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
//     */
//    @Bean(name = "messageSource")
//    public ReloadableResourceBundleMessageSource getMessageSource() {
//        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
//        resource.setBasename("classpath:/locales/messages");
//        resource.setCacheSeconds(1);
//        resource.setDefaultEncoding("UTF-8");
//        return resource;
//    }
}