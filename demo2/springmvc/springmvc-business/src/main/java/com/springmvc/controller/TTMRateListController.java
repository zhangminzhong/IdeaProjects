package com.springmvc.controller;

import com.springmvc.model.TTMRate;
import com.springmvc.service.ITTMRateService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhang_minzhong on 2017/7/13.
 */
public class TTMRateListController extends AbstractController {
    private ITTMRateService ttmRateService;
    private String viewName;

    public ITTMRateService getTtmRateService() {
        return ttmRateService;
    }

    public void setTtmRateService(ITTMRateService ttmRateService) {
        this.ttmRateService = ttmRateService;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<TTMRate> ttmRateList = getTtmRateService().getTTMRatesToday();
        ModelAndView mav = new ModelAndView(getViewName());
        mav.addObject("ttmRates",ttmRateList);
        return mav;
    }

}
