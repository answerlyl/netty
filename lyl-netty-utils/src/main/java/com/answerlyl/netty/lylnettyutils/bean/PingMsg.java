package com.answerlyl.netty.lylnettyutils.bean;


import com.answerlyl.netty.lylnettyutils.constant.MsgType;

public class PingMsg extends BaseMsg {
    public PingMsg() {
        super();
        setType(MsgType.PING);
    }
}