package com.example.Controller;

import com.example.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DeptController_Consumer {
    //    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUDABA-DEPT";
    private static final Logger log = Logger.getGlobal();
    protected final RestTemplate restTemplate;
    @Autowired
    public DeptController_Consumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        log.info(dept.toString());
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/baba")
    public String test() {
        return "baobei";
    }

    //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }

}
