package com.dh.system.po;

import java.util.Date;

import org.springframework.data.annotation.Id;


public class CmsInfoMongo {
	 @Id
	 private String id;

    private String title;//标题
    private String typeName;//新闻类型名称

    private Date createdate;//创建日期

    private Integer sort; //排序

    private Integer status;// 0 下线  1 上线

    private String content;//文本内容
    
    
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}