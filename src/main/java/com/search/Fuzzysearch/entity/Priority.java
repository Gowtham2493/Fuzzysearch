package com.search.Fuzzysearch.entity;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class Priority implements Serializable {
    @CsvBindByName(column = "Table Name") //write csv
    private String tablename;
    @CsvBindByName(column = "Priority")
    private int priority;

    public Priority(){}
    public Priority(String tablename, Integer priority) {
        this.tablename = tablename;
        this.priority = priority;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override  // informs the compiler that the element is meant to override an element declared in a superclass
    public String toString() {
        return "Priority{" +
                "tablename='" + tablename + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
