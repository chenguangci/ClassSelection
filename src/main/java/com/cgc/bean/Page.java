package com.cgc.bean;

public class Page {
    //总条数
    private int totalNumber;
    //当前页
    private int currentPage;
    //总页数
    private int totalPage;
    //从第几条开始取
    private int limitNumber;

    /**
     * 根据当前对象中属性值计算并设置相关属性值
     */
    public void count() {
        int pageNumber = 10;
        // 计算总页数
        int totalPageTemp = this.totalNumber / pageNumber;
        //余下的单独成一页
        int plus = (this.totalNumber % pageNumber) == 0 ? 0 : 1;
        //总页数加一
        totalPageTemp = totalPageTemp + plus;
        if(totalPageTemp <= 0) {
            totalPageTemp = 1;
        }
        this.totalPage = totalPageTemp;

        // 设置limit的参数
        this.limitNumber = (this.currentPage - 1) * pageNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
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

    public int getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(int limitNumber) {
        this.limitNumber = limitNumber;
    }

}
