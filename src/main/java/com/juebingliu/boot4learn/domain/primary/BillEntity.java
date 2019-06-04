package com.juebingliu.boot4learn.domain.primary;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author juebing
 * @date 2018/12/4 19:01
 * @description
 */
@Entity
@Table(name = "bill", schema = "test", catalog = "")
public class BillEntity {
    private String orderId;
    private Integer amount;

    public BillEntity(String orderId, Integer amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public BillEntity() {
    }

    @Id
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillEntity that = (BillEntity) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, amount);
    }
}