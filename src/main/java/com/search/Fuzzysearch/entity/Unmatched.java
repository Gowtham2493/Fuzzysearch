package com.search.Fuzzysearch.entity;

public class Unmatched {
	private String Tbname ;
	private String Colname;
	private String Desc;
	private String Tags;
	
	public Unmatched() {
		
	}
	
	public Unmatched(String tbname, String colname, String desc, String tags) {
		this.Tbname = tbname;
		this.Colname = colname;
		this.Desc = desc;
		this.Tags = tags;
	}



	public String getTbname() {
		return Tbname;
	}
	public void setTbname(String tbname) {
		this.Tbname = tbname;
	}
	public String getColname() {
		return Colname;
	}
	public void setColname(String colname) {
		this.Colname = colname;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		this.Desc = desc;
	}
	public String getTags() {
		return Tags;
	}
	public void setTags(String tags) {
		this.Tags = tags;
	}

	@Override
	public String toString() {
		return "Unmatched [Tbname=" + Tbname + ", Colname=" + Colname + ", Desc=" + Desc + ", Tags=" + Tags + "]";
	}
	
	
	

}
