package com.example.controller;

import com.example.entity.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
class DeptController {
    @Autowired
    private DeptService service;
    private static final Logger log = Logger.getGlobal();
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello")
    public String sayHello() {
        log.info("aaa");
        return "123123";
    }

    @RequestMapping(value = "/dept/add")
    //服务端的接受对象必须加@RequestBody,不然接受前面传过来的对象为空
    public boolean add(@RequestBody Dept dept) {
        log.info(dept.toString());
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        log.info("111111111111111");
        log.info(service.list().toString());
        System.out.println(service.list());
        return service.list();
    }

//    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
//    public Object discovery() {
//        List<String> list = client.getServices();
//        System.out.println("**********" + list);
//
//
//        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
//        for (ServiceInstance element : srvList) {
//            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
//                    + element.getUri());
//        }
//        return this.client;
//    }

}
