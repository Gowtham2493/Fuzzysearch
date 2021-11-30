package com.search.Fuzzysearch.service;

import com.search.Fuzzysearch.entity.*;

import java.util.List;
import java.util.Map;


public interface UploadService {

    public void writeToCSV(String strpath);
    public Map<String,Object> runLogic(List<Source> sources, List<Target> targets, List<Priority> priorities, String threshold);

    List<Source> combineReinfSrc(List<Source> sources, List<Reinforcement> reinforcements);
}
