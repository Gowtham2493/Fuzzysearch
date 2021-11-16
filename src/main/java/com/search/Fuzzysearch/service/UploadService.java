package com.search.Fuzzysearch.service;

import com.search.Fuzzysearch.entity.Output;
import com.search.Fuzzysearch.entity.Priority;
import com.search.Fuzzysearch.entity.Source;
import com.search.Fuzzysearch.entity.Target;
import java.util.List;


public interface UploadService {

    public void writeToCSV(String strpath);
    public List<Output> runLogic(List<Source> sources, List<Target> targets, List<Priority> priorities);

}
