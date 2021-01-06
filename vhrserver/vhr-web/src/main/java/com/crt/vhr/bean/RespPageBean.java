package com.crt.vhr.bean;

import java.util.List;

/**
 * @author chairuntao
 * @version 1.0
 * @date 2020/4/22 12:40
 */
public class RespPageBean {
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }


}
