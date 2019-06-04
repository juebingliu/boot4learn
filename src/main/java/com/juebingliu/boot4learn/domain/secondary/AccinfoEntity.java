package com.juebingliu.boot4learn.domain.secondary;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author juebing
 * @date 2018/12/4 19:02
 * @description
 */
@Entity
@Table(name = "accinfo", schema = "test2", catalog = "")
public class AccinfoEntity {
    private String accountId;
    private Integer balance;

    public AccinfoEntity(String accountId, Integer balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public AccinfoEntity() {
    }

    @Id
    @Column(name = "account_id")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "balance")
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccinfoEntity that = (AccinfoEntity) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance);
    }
}