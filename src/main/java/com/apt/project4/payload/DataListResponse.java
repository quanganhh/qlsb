package com.apt.project4.payload;

import java.util.ArrayList;
import java.util.List;

public class DataListResponse<T> extends BaseResponse {

    private int currentPage = -1;
    private int totalPage = -1;
    private long totalElements = -1;
    private int pageSize;
    private int currentElement;
    private List<T> dataList = new ArrayList<>();

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public DataListResponse(List<T> dataList) {
        super("");
        this.dataList = dataList;
    }

    public DataListResponse(String message, List<T> dataList) {
        super(message);
        this.dataList = dataList;
    }

    public DataListResponse(boolean isSuccess, String message, String errorCode, List<T> dataList) {
        super(isSuccess, message, errorCode);
        this.dataList = dataList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(int currentElement) {
        this.currentElement = currentElement;
    }
}
