package com.flywolf.li.sales.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@ComponentScan("com.flywolf.li")
@SpringBootApplication
@EnableDiscoveryClient //开启服务发现机制
@EnableHystrix//开启熔断降级机制
@EnableFeignClients //开启远程服务调用
@EnableCaching//开启缓存机制
@Controller
public class SalesConfigApp {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginvalidate", method = RequestMethod.POST)
    public String loginvalidate(@RequestParam("username") String username, @RequestParam("password") String pwd, HttpSession httpSession) {
        if (username == null)
            return "login";
        if ("admin".equals(pwd)) {
            httpSession.setAttribute("username", username);
            return "index";
        } else
            return "fail";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("username");
        return "login";
    }

    @RequestMapping(value = "/currentuser", method = RequestMethod.GET)
    @ResponseBody
    public MSG currentuser(HttpSession httpSession) {
        String userid = (String) httpSession.getAttribute("username");
        return new MSG(userid);
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesConfigApp.class, args);
    }
}
