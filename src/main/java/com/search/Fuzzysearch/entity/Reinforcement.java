package com.search.Fuzzysearch.entity;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class Reinforcement implements Serializable {
    @CsvBindByName(column = "Domain")
    private String domain;
    @CsvBindByName(column = "Col Name")
    private String columnName;
    @CsvBindByName(column = "Col Description")
    private String columnDesc;
    @CsvBindByName(column = "Correct Source Table Name")
    private String srcTableName;
    @CsvBindByName(column = "Correct Source Col Name")
    private String srcColName;
    @CsvBindByName(column = "Correct Source Col Description")
    private String srcColDesc;

    public Reinforcement (){}

    public Reinforcement(String domain, String columnName, String columnDesc, String srcTableName, String srcColName, String srcColDesc) {
        this.domain = domain.trim();
        this.columnName = columnName.trim();
        this.columnDesc = columnDesc.trim();
        this.srcTableName = srcTableName.trim();
        this.srcColName = srcColName.trim();
        this.srcColDesc = srcColDesc.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain.trim();
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

    public String getSrcTableName() {
        return srcTableName;
    }

    public void setSrcTableName(String srcTableName) {
        this.srcTableName = srcTableName.trim();
    }

    public String getSrcColName() {
        return srcColName;
    }

    public void setSrcColName(String srcColName) {
        this.srcColName = srcColName.trim();
    }

    public String getSrcColDesc() {
        return srcColDesc;
    }

    public void setSrcColDesc(String srcColDesc) {
        this.srcColDesc = srcColDesc.trim();
    }

    @Override
    public String toString() {
        return "Reinforcement{" +
                "domain='" + domain + '\'' +
                ", columnName='" + columnName + '\'' +
                ", columnDesc='" + columnDesc + '\'' +
                ", srcTableName='" + srcTableName + '\'' +
                ", srcColName='" + srcColName + '\'' +
                ", srcColDesc='" + srcColDesc + '\'' +
                '}';
    }
}
