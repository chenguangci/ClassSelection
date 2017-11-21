package com.cgc.bean;

public class Page {
    //总条数
    private int totalNumber;

    //总页数
    private int totalPage;

    private int pageNumber;

    public Page(int totalNumber,int pageNumber) {
        this.pageNumber = pageNumber;
        this.totalNumber = totalNumber;
        count();
    }

    /**
     * 根据当前对象中属性值计算并设置相关属性值
     */
    private void count() {
        // 计算总页数
        int totalPageTemp = this.totalNumber / pageNumber;
        //余下的单独成一页
        int plus = (this.totalNumber % pageNumber) == 0 ? 0 : 1;
        //总页数加一
        totalPageTemp = totalPageTemp + plus;
        if(totalPageTemp <= 0) {
            totalPageTemp = 1;
        }
        //获取总页数
        this.totalPage = totalPageTemp;

    }

    public int getLimitNumber(int currentPage) {
        return (currentPage-1)*this.pageNumber;
    }
    public int getTotalPage() {
        return this.totalPage;
    }
}
