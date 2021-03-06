package com.juebingliu.boot4learn.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author juebing
 * @date 2018/12/4 17:46
 * @description
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryThird",
        transactionManagerRef="transactionManagerThird",
        basePackages= { "com.juebingliu.boot4learn.service.third" }) //设置Repository所在位置
public class ThirdConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("thirdDataSource")
    private DataSource thirdDataSource;

    private Map<String, Object> getVendorProperties() {
        HibernateSettings hibernateSettings = new HibernateSettings();
        return jpaProperties.getHibernateProperties(hibernateSettings);
    }

    @Bean(name = "entityManagerFactoryThird")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryThird () {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true); //hibernate基本配置
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(true);
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.juebingliu.boot4learn.domain.third");
        factory.setDataSource(thirdDataSource);
        factory.setJpaPropertyMap(getVendorProperties());
        return factory;
    }

//    @Bean(name = "entityManagerThird")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactoryThird(builder).getObject().createEntityManager();
//    }

    @Bean(name = "transactionManagerThird")
    PlatformTransactionManager transactionManagerThird() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactoryThird().getObject());
        return txManager;
    }
}