package link.yangxin.ajaxserver.controller;

import link.yangxin.ajaxserver.bean.ResultBean;
import link.yangxin.ajaxserver.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangxin
 * @date 2020/1/26
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/get1")
    public ResultBean test1() {
        log.info("TestController test1 ");
        return new ResultBean("get1 ok");
    }

    @PostMapping("/postJson")
    public ResultBean postJson(@RequestBody User user) {
        log.info("TestController postJson ");
        return new ResultBean("username is " + user.getName());
    }


    @GetMapping("/getCookie")
    public ResultBean getCookie(@CookieValue(value = "cookie1") String cookie1) {
        log.info("TestController getCookie ");
        return new ResultBean("getCookie " + cookie1);
    }

    /**
     * 获取请求头也可以使用 RequestHeader注解 value = x-header1
     * @param request
     * @return
     */
    @GetMapping("/getHeader")
    public ResultBean getHeader(HttpServletRequest request) {
        log.info("TestController getHeader ");
        String header1 = request.getHeader("x-header1");
        String header2 = request.getHeader("x-header2");
        String openId = request.getHeader("x-openid");
        return new ResultBean("getHeader " + String.format("%s %s %s", header1, header2, openId));
    }

}