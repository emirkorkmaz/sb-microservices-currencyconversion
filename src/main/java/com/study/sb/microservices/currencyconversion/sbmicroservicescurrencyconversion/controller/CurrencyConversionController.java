package com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.controller;

import com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.entity.CurrencyConversionDetail;
import com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.entity.CurrencyExchangeDetail;
import com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.proxy.ForexServicesProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public Environment environment;

    @Autowired
    public ForexServicesProxy forexServicesProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversionDetail convertCurrency(@PathVariable String from, @PathVariable String to,
                                                    @PathVariable BigDecimal amount) {
        CurrencyConversionDetail currencyConversionDetail = null;
        CurrencyExchangeDetail currencyExchangeDetail = null;

        /**
         * use feign proxy is switch is open, rest client otherwise
         */
        if(Boolean.valueOf(environment.getProperty("service.feignproxy.active"))) {
            currencyExchangeDetail = forexServicesProxy.getCurrencyExchangeDetail(from, to);

            logger.info("{}", currencyExchangeDetail);

            if(null != currencyExchangeDetail) {
                currencyConversionDetail = new CurrencyConversionDetail(currencyExchangeDetail.getId(),
                        from, to, currencyExchangeDetail.getConversionRate(), amount,
                        amount.multiply(currencyExchangeDetail.getConversionRate()),
                        currencyExchangeDetail.getPort());
            }
        } else {
            //We'll be invoking Forex Services microservice to get conversion rate
            //hence we need to setup the parameters
            Map<String, String> fsRequestParam = new HashMap<>();
            fsRequestParam.put("from",from);
            fsRequestParam.put("to",to);

            //Using Rest Client for invocation
            ResponseEntity<CurrencyConversionDetail> conversionDetailResponseEntity = new RestTemplate().
                    getForEntity("http://localhost:19000/currency-exchange-info/from/{from}/to/{to}",
                            CurrencyConversionDetail.class, fsRequestParam);

            CurrencyConversionDetail tmpCurrencyConversionDetail = conversionDetailResponseEntity.getBody();

            if(null != tmpCurrencyConversionDetail) {
                currencyConversionDetail = new CurrencyConversionDetail(tmpCurrencyConversionDetail.getId(),
                        from, to, tmpCurrencyConversionDetail.getConversionRate(), amount,
                        amount.multiply(tmpCurrencyConversionDetail.getConversionRate()),
                        tmpCurrencyConversionDetail.getPort());
            }
        }

        return currencyConversionDetail;
    }
}
