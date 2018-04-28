package com.yom.multidatasources.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yogendra on 24/4/18.
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "insuranceEntityManagerFactory",
        transactionManagerRef = "insuranceTransactionManager",
        basePackages = {"com.yom.multidatasources.insurance.repository"})
public class InsuranceDbConfig {

    @Bean(name = "insuranceDataSource")
    @ConfigurationProperties(prefix = "insurance.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "insuranceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("insuranceDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.yom.multidatasources.insurance.entity")
                .properties(jpaProperties())
                .persistenceUnit("insurance").build();
    }

    @Bean(name = "insuranceTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("insuranceEntityManagerFactory")EntityManagerFactory
                                                                 entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }


    private Map<String,Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        return props;
    }
}
