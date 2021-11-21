package com.search.Fuzzysearch.entity;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class Target implements Serializable {
    @CsvBindByName(column = "Table Name")
    private String tableName;
    @CsvBindByName(column = "Column Name")
    private String columnName;
    @CsvBindByName(column = "Column Description")
    private String columnDesc;
    @CsvBindByName(column = "Tags")
    private String columnTag;

    public Target (){}
    public Target(String tableName, String columnname, String columndesc, String columntag) {
        this.tableName = tableName.trim();
        this.columnName = columnname.trim();
        this.columnDesc = columndesc.trim();
        this.columnTag = columntag.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName.trim();
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName.trim();
    }

    public String getColumnDesc() {
        return columnDesc;
    }

    public void setColumnDesc(String columnDesc) {
        this.columnDesc = columnDesc.trim();
    }

    public String getColumnTag() {
        return columnTag;
    }

    public void setColumnTag(String columnTag) {
        this.columnTag = columnTag.trim();
    }

    @Override
    public String toString() {
        return "Source{" +
                "tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", columnDesc='" + columnDesc + '\'' +
                ", columnTag='" + columnTag + '\'' +
                '}';
    }
}
