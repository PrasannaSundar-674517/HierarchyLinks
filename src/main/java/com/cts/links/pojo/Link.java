package com.cts.links.pojo;

import javax.persistence.Column;
import javax.persistence.Table;
@Table(name="link_mapping")
public class Link {
	@Column(name="link_Id")
	private int linkId;
	@Column(name="link_Name")
	private String linkName;
	private int parentLinkId;

	public Link(int linkId, String linkName, int parentLinkId) {
		super();
		this.linkId = linkId;
		this.linkName = linkName;
		this.parentLinkId = parentLinkId;
	}

	public int getLinkId() {
		return linkId;
	}

	public void setLink_Id(int linkId) {
		this.linkId = linkId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public int getParentLinkId() {
		return parentLinkId;
	}

	public void setParentLinkId(int parentLinkId) {
		this.parentLinkId = parentLinkId;
	}

	public Link() {
		super();
	}

	@Override
	public String toString() {
		return "Link [linkName=" + linkName + "]\n";
	}
	
	

}
