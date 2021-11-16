package com.search.Fuzzysearch.entity;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class Source implements Serializable {

    @CsvBindByName(column = "Table Name")
    private String tablename;
    @CsvBindByName(column = "Column Name")
    private String columnname;
    @CsvBindByName(column = "Column Description")
    private String columndesc;
    @CsvBindByName(column = "Column Tag")
    private String columntag;

    public Source (){}
    public Source(String tablename, String columnname, String columndesc, String columntag) {
        this.tablename = tablename;
        this.columnname = columnname;
        this.columndesc = columndesc;
        this.columntag = columntag;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public String getColumndesc() {
        return columndesc;
    }

    public void setColumndesc(String columndesc) {
        this.columndesc = columndesc;
    }

    public String getColumntag() {
        return columntag;
    }

    public void setColumntag(String columntag) {
        this.columntag = columntag;
    }

    @Override
    public String toString() {
        return "Source{" +
                "tablename='" + tablename + '\'' +
                ", columnname='" + columnname + '\'' +
                ", columndesc='" + columndesc + '\'' +
                ", columntag='" + columntag + '\'' +
                '}';
    }
}
