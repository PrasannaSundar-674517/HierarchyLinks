package com.cts.links.pojo;

public class Page {
	private Integer pageId;
	private String pageName;
	private Integer ParentPageId;
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public Integer getParentPageId() {
		return ParentPageId;
	}
	public void setParentPageId(Integer parentPageId) {
		ParentPageId = parentPageId;
	}
	public Page(Integer pageId, String pageName, Integer parentPageId) {
		super();
		this.pageId = pageId;
		this.pageName = pageName;
		ParentPageId = parentPageId;
	}
	public Page() {
		super();
	} 
	
	
	

}
