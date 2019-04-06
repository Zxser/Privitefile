package com.dh.guangfu.vo;

import java.util.Date;

import com.dh.system.base.BaseEntity;

public class CmsInfoQuery extends BaseEntity {
	private String typeName;
	 private Long id;
	 private String[] arrayId ;
	    private String title;

	    private Date createdate;

	    private Integer sort;

	    private Integer status;

	    private String content;
	    
	    private String name;
	    


	public String[] getArrayId() {
			return arrayId;
		}

		public void setArrayId(String[] arrayId) {
			this.arrayId = arrayId;
		}

	public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
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
			this.content = content;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTypeName() {
			return typeName;
		}

		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}
		
}