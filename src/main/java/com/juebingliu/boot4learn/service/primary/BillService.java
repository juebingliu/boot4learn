package com.juebingliu.boot4learn.service.primary;

import com.juebingliu.boot4learn.domain.primary.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author juebing
 * @date 2018/12/4 19:04
 * @description
 */
public interface BillService extends JpaRepository<BillEntity,String> {
}