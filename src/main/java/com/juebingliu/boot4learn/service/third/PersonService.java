package com.juebingliu.boot4learn.service.third;

import com.juebingliu.boot4learn.domain.third.PersonEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author juebing
 * @date 2018/12/4 19:06
 * @description
 */
@CacheConfig(cacheNames = "users")
public interface PersonService extends JpaRepository<PersonEntity,Long> {

    @Cacheable
    public PersonEntity findByName(String name);
}