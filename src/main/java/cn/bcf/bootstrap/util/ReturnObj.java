package cn.bcf.bootstrap.util;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class ReturnObj<T> {

    //返回码
    //1 成功 ，0 失败
    private String msgCode;

    //返回码的描述
    private String msg;

    //跳转路径
    private String url;

    private T entity;

    private List<T> entityList;

    private JSONObject jsonObject;

    //分页用
    private int total;

    //分页用
    private List<T> rows;

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public List<T> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<T> entityList) {
        this.entityList = entityList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public String toString() {
        return "ReturnObj{" +
                "msgCode='" + msgCode + '\'' +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                ", entity=" + entity +
                ", entityList=" + entityList +
                ", jsonObject=" + jsonObject +
                ", total=" + total +
                ", rows=" + rows +
                '}';
    }
}
