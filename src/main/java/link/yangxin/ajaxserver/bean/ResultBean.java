package link.yangxin.ajaxserver.bean;

import lombok.Data;

/**
 * @author yangxin
 * @date 2020/1/26
 */
@Data
public class ResultBean {

    private String data;

    public ResultBean(String data) {
        this.data = data;
    }
}