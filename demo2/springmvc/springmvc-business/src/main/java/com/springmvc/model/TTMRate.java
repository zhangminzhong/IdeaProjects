package com.springmvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhang_minzhong on 2017/7/13.
 */
public class TTMRate implements Serializable {
    private static final long serialVersionUID = 2941189625594925925L;
    private Date frontDate;
    private String currencyPair;
    private BigDecimal value;

    public TTMRate(Date frontDate, String currencyPair, BigDecimal value) {
        this.currencyPair = currencyPair;
        this.frontDate = frontDate;
        this.value = value;
    }

    public Date getFrontDate() {
        return frontDate;
    }

    public void setFrontDate(Date frontDate) {
        this.frontDate = frontDate;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
