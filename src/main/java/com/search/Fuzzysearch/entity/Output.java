package com.search.Fuzzysearch.entity;


public class Output implements Comparable<Output>{
    private String tTbName;
    private String tColName;
    private String tDesc;
    private String sTbName;
    private String sColName;
    private String sDesc;
    private String percentage;
    private String priority;
    private String retable;
    private String recolumn;

    public  Output(){}

    public Output(String tTbName, String tColName, String tDesc, String sTbName, String sColName, String sDesc, String percentage, String priority, String retable, String recol) {
        this.tTbName = tTbName;
        this.tColName = tColName;
        this.tDesc = tDesc;
        this.sTbName = sTbName;
        this.sColName = sColName;
        this.sDesc = sDesc;
        this.percentage = percentage;
        this.priority = priority;
        this.retable = retable;
        this.recolumn = recol;
    }

    public String gettTbName() {
        return tTbName;
    }

    public void settTbName(String tTbName) {
        this.tTbName = tTbName;
    }

    public String gettColName() {
        return tColName;
    }

    public void settColName(String tColName) {
        this.tColName = tColName;
    }

    public String gettDesc() {
        return tDesc;
    }

    public void settDesc(String tDesc) {
        this.tDesc = tDesc;
    }

    public String getsTbName() {
        return sTbName;
    }

    public void setsTbName(String sTbName) {
        this.sTbName = sTbName;
    }

    public String getsColName() {
        return sColName;
    }

    public void setsColName(String sColName) {
        this.sColName = sColName;
    }

    public String getsDesc() {
        return sDesc;
    }

    public void setsDesc(String sDesc) {
        this.sDesc = sDesc;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRetable() {
        return retable;
    }

    public void setRetable(String retable) {
        this.retable = retable;
    }

    public String getRecolumn() {
        return recolumn;
    }

    public void setRecolumn(String recolumn) {
        this.recolumn = recolumn;
    }

    @Override
    public int compareTo(Output o) {
        return this.getPercentage().compareTo(o.percentage);
    }

    @Override
    public String toString() {
        return "Output{" +
                "tTbName='" + tTbName + '\'' +
                ", tColName='" + tColName + '\'' +
                ", tDesc='" + tDesc + '\'' +
                ", sTbName='" + sTbName + '\'' +
                ", sColName='" + sColName + '\'' +
                ", sDesc='" + sDesc + '\'' +
                ", percentage='" + percentage + '\'' +
                ", priority='" + priority + '\'' +
                ", retable='" + retable + '\'' +
                ", recolumn='" + recolumn + '\'' +
                '}';
    }
}
