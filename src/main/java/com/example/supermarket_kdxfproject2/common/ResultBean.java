package com.example.supermarket_kdxfproject2.common;

public class ResultBean {
    private String code;
    private String msg;


    public ResultBean() {
    }

    public ResultBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "resultBean{code = " + code + ", msg = " + msg + "}";
    }
}
