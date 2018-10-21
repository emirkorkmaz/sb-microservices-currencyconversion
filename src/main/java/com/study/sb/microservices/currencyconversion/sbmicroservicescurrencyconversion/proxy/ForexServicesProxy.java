package com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.proxy;

import com.study.sb.microservices.currencyconversion.sbmicroservicescurrencyconversion.entity.CurrencyExchangeDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "forex-services-proxy", url = "localhost:19000")
public interface ForexServicesProxy {

    @GetMapping("/currency-exchange-info/from/{from}/to/{to}")
    CurrencyExchangeDetail getCurrencyExchangeDetail(@PathVariable("from") String from,
                                                     @PathVariable("to") String to);
}
