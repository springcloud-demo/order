package com.imooc.order.Controller;

import com.imooc.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ClientController {
//    @Autowired1
//    private LoadBalancerClient loadBalancerClient;
//    @Autowired
//    private RestTemplate restTemplate;
//    @RequestMapping("/getProductMsg")
//    public String getProductMsg(){
        //第一种方式,到那时当有多个地址的时候就有问题了
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8083/msg",String.class);
        //第二种方式,利用应用名获取url,再使用restTemplate.
//        ServiceInstance serviceInstance = loadBalancerClient.choose("Product");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url,String.class);
        //第三种方式(利用@LoadBalanced,可在restTemplate里使用应用名字)
//        String response =  restTemplate.getForObject("http://PRODUCT/msg",String.class);
//        log.info("response={}",response);
//        return response;
//    }
    @Autowired
    private ProductClient productClient;

//    @GetMapping("/getProductMsg")
//    public String getProductMsg(){
//        String response = productClient.productMsg();
//        log.info("response={}",response);
//        return response;
//    }
//    @GetMapping("/getProductList")
//    public String getProductList(){
//        log.info("已映射开始执行");
//        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("164103465734242707"));
//        log.info("response:{}",productInfoList);
//        return "ok";
//    }
//    @GetMapping("productDecreaseStock")
//    public String productDecreaseStock(){
//        productClient.decreaseStock(Arrays.asList(new CartDTO("164103465734242707",3)));
//        return "ok";
//    }


}