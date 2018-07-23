package com.answerlyl.netty.lylnettyserver.bean;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "用户对象",description="answerFinance")
public class AnswerFinance {

    private Integer id;

    private Integer type;

    private Double money;

    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
