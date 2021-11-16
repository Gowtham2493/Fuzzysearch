package com.search.Fuzzysearch.entity;

import com.opencsv.bean.CsvBindByName;

public class Output {
    @CsvBindByName(column = "Target Table")
    private String targettable;
    @CsvBindByName(column = "Target Column")
    private String targetcolumn;
    @CsvBindByName(column = "Matched Table")
    private String matchedtable;
    @CsvBindByName(column = "Matched Column")
    private String matchedcolumn;
    @CsvBindByName(column = "Percentage")
    private String percentage;
    @CsvBindByName(column = "Priority")
    private String priority;

    public  Output(){}
    public Output(String targettable, String targetcolumn, String matchedtable, String matchedcolumn, String percentage, String priority) {
        this.targettable = targettable;
        this.targetcolumn = targetcolumn;
        this.matchedtable = matchedtable;
        this.matchedcolumn = matchedcolumn;
        this.percentage = percentage;
        this.priority = priority;
    }

    public String getTargettable() {
        return targettable;
    }

    public void setTargettable(String targettable) {
        this.targettable = targettable;
    }

    public String getTargetcolumn() {
        return targetcolumn;
    }

    public void setTargetcolumn(String targetcolumn) {
        this.targetcolumn = targetcolumn;
    }

    public String getMatchedtable() {
        return matchedtable;
    }

    public void setMatchedtable(String matchedtable) {
        this.matchedtable = matchedtable;
    }

    public String getMatchedcolumn() {
        return matchedcolumn;
    }

    public void setMatchedcolumn(String matchedcolumn) {
        this.matchedcolumn = matchedcolumn;
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
}
