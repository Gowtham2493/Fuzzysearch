package com.search.Fuzzysearch.service;

import com.search.Fuzzysearch.entity.*;

import java.util.List;


public interface UploadService {

    public void writeToCSV(String strpath);
    public List<Output> runLogic(List<Source> sources, List<Target> targets, List<Priority> priorities);

    List<Source> combineReinfSrc(List<Source> sources, List<Reinforcement> reinforcements);
}
