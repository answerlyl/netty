package com.answerlyl.netty.lylnettyutils.bean;


import com.answerlyl.netty.lylnettyutils.constant.MsgType;

public class ReplyMsg extends BaseMsg {
    public ReplyMsg() {
        super();
        setType(MsgType.REPLY);
    }
    private ReplyBody body;

    public ReplyBody getBody() {
        return body;
    }

    public void setBody(ReplyBody body) {
        this.body = body;
    }
}
