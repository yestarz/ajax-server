package link.yangxin.ajaxserver;

import link.yangxin.ajaxserver.filter.MyCorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AjaxServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AjaxServerApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");
        bean.setFilter(new MyCorsFilter());
        return bean;
    }

}
