package lab.one.demo.config;

import lab.one.demo.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.hibernate.cfg.Configuration;



@org.springframework.context.annotation.Configuration
public class HibernateConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;

    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private String hibernateFormatSql;

    @Value("${spring.jpa.properties.hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;

    @Value("${spring.jpa.properties.hibernate.use_sql_comments}")
    private String hibernateUseSqlComments;

    @Bean
    public SessionFactory sessionFactory(){
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", hibernateDialect);
        configuration.setProperty("hibernate.show_sql", hibernateShowSql);
        configuration.setProperty("hibernate.format_sql", hibernateFormatSql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        configuration.setProperty("hibernate.use_sql_comments", hibernateUseSqlComments);

        // Устанавливаем параметры соединения с базой данных
        configuration.setProperty("hibernate.connection.url", dbUrl);
        configuration.setProperty("hibernate.connection.username", dbUsername);
        configuration.setProperty("hibernate.connection.password", dbPassword);

        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Publisher.class);
        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Library.class);

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        return configuration.buildSessionFactory(serviceRegistryBuilder.build());
    }
}
