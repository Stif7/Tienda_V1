package com.tienda;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {
    /* Los siguientes métodos son para incorporar el tema de internacionalización en el proyecto */
    
    /* localeResolver se utiliza para crear una sesión de cambio de idioma*/
    @Bean
    /* Un bean es permitirnos extraer localeresolver(sirve para hacer una secion de cambio de idioma) y poder modificarlo*/
    public LocaleResolver localeResolver() {
      
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());/* para agarrar un localizacion */
        slr.setLocaleAttributeName("session.current.locale"); /*Para agarrar la secion por si llegar a cambiar el lugar donde estemos*/
        slr.setTimeZoneAttributeName("session.current.timezone"); /* ZONA HORARIA*/
        return slr;
    }

    /* localeChangeInterceptor se utiliza para crear un interceptor de cambio de idioma*/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();/*EL PARAMETRO PARA CAMBIAR EL IDIOMA*/
        lci.setParamName("lang");
        return lci;
    }

    @Override
    /*SI QUEREMOS HACER MAS CAMBIOS DE IDIOMA*/
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

    //Bean para poder acceder a los Messages.properties en código...
    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
        /*UN FORMATO DE CARACTERES---->UFT-8*/
    }
}