package com.imooc.order.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
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
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(){
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.postForObject("http://127.0.0.1:8082/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);
    }
    private String defaultFallback(){
        return "默认提示:太拥挤了,请稍后再试~~";
    }
}

//        throw new RuntimeException("发生异常了");
//        if(服务太多,并发太高)
/*private String fallback(){
        return "太拥挤了,请稍后再试~~";
    }*/