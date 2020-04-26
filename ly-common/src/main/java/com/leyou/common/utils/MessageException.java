package com.leyou.common.utils;

/**
 * @author fenghu
 * @description: TODO
 * @date 2020-04-20 17:03
 */
public class MessageException extends RuntimeException {
    private  static final long serialVersionUID = -7034897190745766931L;
    private Result model = new Result();
    public Result getModel(){
        return  model;
    }
    public MessageException(){
        super();
    }
    public MessageException(String errMsg){
        super(500 + "/" + errMsg);
        this.model.setCode("500");
        this.model.setMsg(errMsg);
    }
    public MessageException(String errCode, String errMsg){
        super(errCode + "/" + errMsg);
        this.model.setCode(errCode);
        this.model.setMsg(errMsg);
    }
    public MessageException(String errCode, String errMsg,StackTraceElement[] stackTrace){
        super(errCode + "/" + errMsg);
        this.model.setCode(errCode);
        this.model.setMsg(errMsg);
        this.setStackTrace(stackTrace);
    }
    public MessageException(String errCode, String errMsg, Throwable exception){
        super(errCode + "/" + errMsg,exception);
    }
    public String getSuccess(){
        return this.model.getCode();
    }
    public String getMessage(){
        return this.model.getMsg();
    }
}
