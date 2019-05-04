package com.example.controller;

import com.example.entity.Dept;
import com.example.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
         Dept dept =  this.service.get(id);
         log.info("hystrix212");
         log.info(dept.toString());
         if(null == dept)
            {
             throw new RuntimeException("该ID："+id+"没有没有对应的信息");
            }
        return dept;
    }
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        log.info("111111111111111");
        log.info(service.list().toString());
        System.out.println(service.list());
        return service.list();
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id)
  {
      log.info("212");
   return new Dept().setDeptNo(id)
           .setName("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
           .setDb_source("no this database in MySQL");
  }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("**********" + list);


        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUDABA-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
