package com.hp.controller;

import com.hp.entity.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private RestTemplate restTemplate;//eureka 客户端

    @Autowired
    private DiscoveryClient discoveryClient;

//    @GetMapping("/{i}")
//    public UserInfo getUser(@PathVariable("i") Long i){
//        UserInfo user = restTemplate.getForObject("http://localhost:8089/user/" + i, UserInfo.class);
//        return  user;
//    }
//@GetMapping("/{i}")
//public UserInfo getUser(@PathVariable("i") Long i){
//    //获取服务列表
//    List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//    //获取服务实例
//    ServiceInstance serviceInstance = instances.get(0);
//
//    String host=serviceInstance.getHost();
//    int port=serviceInstance.getPort();
//    String url="http://"+host+":"+port+"/user/"+i;
//    UserInfo user = restTemplate.getForObject(url, UserInfo.class);
//    return  user;
//}
@GetMapping("/{i}")
public UserInfo getUser(@PathVariable("i") Long i){
    String url="http://user-service/user/"+i;
    UserInfo user = restTemplate.getForObject(url, UserInfo.class);
    return  user;
}

}
