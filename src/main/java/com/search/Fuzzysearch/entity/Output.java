package com.search.Fuzzysearch.entity;


public class Output implements Comparable<Output>{
    private String TargetTable;
    private String TargetColumn;
    private String TargetDesc;
    private String SrcTable;
    private String SrcColumn;
    private String SrcDesc;
    private String Percentage;
    private String Priority;

    public  Output(){}

    public Output(String targetTable, String targetColumn, String targetDesc, String srcTable, String srcColumn, String srcDesc, String percentage, String priority) {
        TargetTable = targetTable;
        TargetColumn = targetColumn;
        TargetDesc = targetDesc;
        SrcTable = srcTable;
        SrcColumn = srcColumn;
        SrcDesc = srcDesc;
        Percentage = percentage;
        Priority = priority;
    }

    public String getTargetTable() {
        return TargetTable;
    }

    public void setTargetTable(String targetTable) {
        TargetTable = targetTable;
    }

    public String getTargetColumn() {
        return TargetColumn;
    }

    public void setTargetColumn(String targetColumn) {
        TargetColumn = targetColumn;
    }

    public String getTargetDesc() {
        return TargetDesc;
    }

    public void setTargetDesc(String targetDesc) {
        TargetDesc = targetDesc;
    }

    public String getSrcTable() {
        return SrcTable;
    }

    public void setSrcTable(String srcTable) {
        SrcTable = srcTable;
    }

    public String getSrcColumn() {
        return SrcColumn;
    }

    public void setSrcColumn(String srcColumn) {
        SrcColumn = srcColumn;
    }

    public String getSrcDesc() {
        return SrcDesc;
    }

    public void setSrcDesc(String srcDesc) {
        SrcDesc = srcDesc;
    }

    public String getPercentage() {
        return Percentage;
    }

    public void setPercentage(String percentage) {
        Percentage = percentage;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    @Override
    public String toString() {
        return "Output{" +
                "TargetTable='" + TargetTable + '\'' +
                ", TargetColumn='" + TargetColumn + '\'' +
                ", TargetDesc='" + TargetDesc + '\'' +
                ", SrcTable='" + SrcTable + '\'' +
                ", SrcColumn='" + SrcColumn + '\'' +
                ", SrcDesc='" + SrcDesc + '\'' +
                ", Percentage='" + Percentage + '\'' +
                ", Priority='" + Priority + '\'' +
                '}';
    }

    @Override
    public int compareTo(Output o) {
        return this.getPercentage().compareTo(o.Percentage);
    }
}
