package com.juebingliu.boot4learn.service.secondary;

import com.juebingliu.boot4learn.domain.secondary.AccinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author juebing
 * @date 2018/12/4 19:05
 * @description
 */
public interface AccInfoService extends JpaRepository<AccinfoEntity,String> {
}