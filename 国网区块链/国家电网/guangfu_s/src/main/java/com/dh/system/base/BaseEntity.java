/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.dh.system.base;

/**
 * 基础信息
 *
 */
public class BaseEntity {
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    public static final Integer MAX_PAGE_SIZE = 100;

    public static final Integer DEFAULT_PAGE_NUM = 1;
    private Integer pageNum;
    private Integer pageSize;
    private Long totalCount;


    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageNum() {
        pageNum = pageNum != null ? pageNum : DEFAULT_PAGE_NUM;
        pageNum = pageNum > 0 ? pageNum : DEFAULT_PAGE_NUM;
        return pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        pageSize = pageSize != null ? pageSize : DEFAULT_PAGE_SIZE;
        pageSize = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
        pageSize = Math.min(pageSize, MAX_PAGE_SIZE);
        return pageSize;
    }
    //偏移量
    public Integer getOffset(){
        Integer offset=(getPageNum() -1) * getPageSize();
        return offset;
    }
    public Long getTotalCount(){
        return totalCount;
    }
    //记录总数
    public void setTotalCount(Long totalCount){
        this.totalCount=totalCount;
    }
}
