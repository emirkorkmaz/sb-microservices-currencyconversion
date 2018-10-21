package com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.proxy;

import com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.entity.CurrencyExchangeDetail;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "forex-service")
@RibbonClient(name = "forex-service")
public interface ForexServicesProxy {

    @GetMapping("/currency-exchange-info/from/{from}/to/{to}")
    CurrencyExchangeDetail getCurrencyExchangeDetail(@PathVariable("from") String from,
                                                     @PathVariable("to") String to);
}
