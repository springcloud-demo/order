package com.imooc.order.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @ClassName: HystrixController
 * @Description: TODO
 * @Author: ZhangChen
 * @Date: 2019/7/2 10:10
 **/

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),                   //设置熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
//    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number")Integer number){
        RestTemplate restTemplate = new RestTemplate();
        if(number%2==0) return "success";
        return  restTemplate.postForObject("http://127.0.0.1:8082/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);
    }
    private String defaultFallback(){
        return "默认提示:太拥挤了,请稍后再试~~";
    }
}