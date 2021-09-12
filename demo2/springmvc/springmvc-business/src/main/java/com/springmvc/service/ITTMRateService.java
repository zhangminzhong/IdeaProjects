package com.springmvc.service;

import com.springmvc.model.TTMRate;

import java.util.List;

/**
 * Created by zhang_minzhong on 2017/7/13.
 */
public interface ITTMRateService {
    public List<TTMRate> getTTMRatesToday();
}
