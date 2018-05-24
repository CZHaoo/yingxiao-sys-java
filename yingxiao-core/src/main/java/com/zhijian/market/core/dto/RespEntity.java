package com.zhijian.market.core.dto;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * 接口响应消息类
 * @param <> 数据
 */

public class RespEntity<E> {
    private Integer status;
    private String info;
    private E data;

    public RespEntity(Integer status, String msg, E data) {
        this.status = status;
        this.info = msg;
        this.data = data;
    }

    public static RespEntity success() {
        return new RespEntity<>(1,null,null);
    }

    public static <E> RespEntity<E> success(E msg) {
        if (msg instanceof String) {
            return new RespEntity<>(1, (String) msg, msg);
        } else {
            return new RespEntity<>(1, "", msg);
        }
    }

    public static <E> RespEntity<E> success(String msg, E data) {
        return new RespEntity<>(1, msg, data);
    }

    public static RespEntity fail() {
        return new RespEntity(0, "", null);
    }

    public static RespEntity fail(String msg) {
        return new RespEntity(0, msg, null);
    }

    public static RespEntity<PageEntity> successPage(List<?> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            PageEntity basePageResp = new PageEntity();
            basePageResp.setList(page);
            basePageResp.setPageNum(page.getPageNum());
            basePageResp.setPageSize(page.getPageSize());
            basePageResp.setTotal(page.getTotal());
            return RespEntity.success(basePageResp);
        }
        return RespEntity.success();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}