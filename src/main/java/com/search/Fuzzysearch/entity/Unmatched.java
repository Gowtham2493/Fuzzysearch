package com.search.Fuzzysearch.entity;

public class Unmatched {
	private String tbName ;
	private String colName;
	private String desc;
	private String tags;
	
	public Unmatched() {
		
	}

	public Unmatched(String tbName, String colName, String desc, String tags) {
		this.tbName = tbName;
		this.colName = colName;
		this.desc = desc;
		this.tags = tags;
	}

	public String getTbName() {
		return tbName;
	}

	public void setTbName(String tbName) {
		this.tbName = tbName;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Unmatched{" +
				"tbName='" + tbName + '\'' +
				", colName='" + colName + '\'' +
				", desc='" + desc + '\'' +
				", tags='" + tags + '\'' +
				'}';
	}
}
