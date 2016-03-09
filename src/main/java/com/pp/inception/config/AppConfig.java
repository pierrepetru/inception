package com.pp.inception.config;

/**
 * Created by pdinulescu on 3/3/2016.
 */

        import com.pp.inception.model.Database;
        import com.pp.inception.repository.HibernateDataBaseConnection;
        import com.pp.inception.repository.HibernateRepository;
        import com.typesafe.config.Config;
        import com.typesafe.config.ConfigFactory;
        import org.hibernate.SessionFactory;
        import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.MessageSource;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.PropertySource;
        import org.springframework.context.support.ResourceBundleMessageSource;
        import org.springframework.core.env.Environment;
        import org.springframework.core.io.ClassPathResource;
        import org.springframework.web.servlet.ViewResolver;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;
        import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
        import org.springframework.web.servlet.view.InternalResourceViewResolver;
        import org.springframework.web.servlet.view.JstlView;

        import javax.xml.crypto.Data;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;
        import java.util.ResourceBundle;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.pp.inception.controller","com.pp.inception.service.connection","com.pp.inception.repository","com.pp.inception.model"})

public class AppConfig {


    @Bean
    public HibernateRepository hibernateRepository(){
        HibernateRepository hib = new HibernateRepository() ;
        return hib ;
    }

    @Bean
    public Database mydata(){

        System.out.println("*********************************************Database object ***************************************************************************");

            Database db = new Database();
            db.setType("hibernate");
            db.setDriver("com.mysql.jdbc.Driver");
            db.setUrl("jdbc:mysql://localhost:3306/inception_db");
            db.setName("test");
            db.setUsername("root");
            db.setPassword("root2");

            db.setPort("3306");
            // db.setPort("27017");
            db.setDialect("org.hibernate.dialect.MySQLDialect");
            db.setShow_sql("hibernate.show_sql");
            db.setFormat_sql("hibernate.format_sql");

            db.setHost("localhost");


return db ;



    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pdfs/**").addResourceLocations("/WEB-INF/pdf/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
    }

}

