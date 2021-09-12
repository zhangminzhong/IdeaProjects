package com.springmvc.service;

import com.springmvc.model.TTMRate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhang_minzhong on 2017/7/13.
 */
public class MockTTMRateService implements ITTMRateService {

    @Override
    public List<TTMRate> getTTMRatesToday(){
        TTMRate USD_JPY = new TTMRate(new Date(),"USD/JPY",new BigDecimal("121.53"));
        TTMRate EUR_USD = new TTMRate(new Date(),"EUR_USD",new BigDecimal("1.8950"));
        List<TTMRate> rateList = new ArrayList<TTMRate>();
        rateList.add(USD_JPY);
        rateList.add(EUR_USD);
        return rateList;
    }

}
