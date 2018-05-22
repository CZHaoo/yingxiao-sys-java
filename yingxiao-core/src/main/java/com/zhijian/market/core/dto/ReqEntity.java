package com.zhijian.market.core.dto;

/**
 * 接口请求 消息类
 * @param <E>
 */
public class ReqEntity<E> {
    private E data;
    private Integer pageNum;
    private Integer pageSize;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Integer getPageNum() {
        return pageNum == null? 0: pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null? 0: pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
