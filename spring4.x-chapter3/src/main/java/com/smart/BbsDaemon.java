package com.smart;

/**
 * EnableAutoConfiguration注解是由Boot提供的，用于对Spring框架进行自动配置，减少了开发人员的工作量<br>
 * RestController和@RequestMapping注解是由Spring MVC提供的，用于创建Rest服务。<br>
 * 直接运行BbsDaemon类会启动一个运行于8080端口的内嵌Tomcat服务，在浏览器中访问“http://localhost:8080”，即可看到页面上显示“欢迎光临小春论坛!”。
 */
//@RestController
//@EnableAutoConfiguration
public class BbsDaemon {
//    @RequestMapping("/")
    public String index() {
        return "欢迎光临小春论坛!";
    }

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(BbsDaemon.class, args);
    }
}
