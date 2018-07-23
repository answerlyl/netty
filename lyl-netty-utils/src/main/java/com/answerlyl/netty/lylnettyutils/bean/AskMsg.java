package com.answerlyl.netty.lylnettyutils.bean;


import com.answerlyl.netty.lylnettyutils.constant.MsgType;

public class AskMsg extends BaseMsg {
    public AskMsg() {
        super();
        setType(MsgType.ASK);
    }
    private AskParams params;

    public AskParams getParams() {
        return params;
    }

    public void setParams(AskParams params) {
        this.params = params;
    }
}
