package com.search.Fuzzysearch.service;

import com.opencsv.CSVWriter;
import com.search.Fuzzysearch.entity.Output;
import com.search.Fuzzysearch.entity.Priority;
import com.search.Fuzzysearch.entity.Source;
import com.search.Fuzzysearch.entity.Target;
import me.xdrop.fuzzywuzzy.FuzzySearch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class UploadServiceImp implements UploadService{
    @Override
    public void writeToCSV(String filePath) {

            // first create file object for file placed at location
            // specified by filepath
            File file = new File(filePath);

            try {
                // create FileWriter object with file as parameter
                FileWriter outputfile = new FileWriter(file);

                // create CSVWriter object filewriter object as parameter
                CSVWriter writer = new CSVWriter(outputfile);

                // create a List which contains String array
                List<String[]> data = new ArrayList<String[]>();
                data.add(new String[] { "Name", "Class", "Marks" });
                data.add(new String[] { "Aman", "10", "620" });
                data.add(new String[] { "Suraj", "10", "630" });
                writer.writeAll(data);

                // closing writer connection
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }


    }

    @Override
    public List<Output> runLogic(List<Source> sources, List<Target> targets, List<Priority> priorities) {
        Collection<Source> sourceCollection = sources;
        Collections.sort(priorities, Comparator.comparingInt(p -> p.getPriority()));
        List<Output> outputList = new ArrayList<Output>();
        Output output = new Output();
        System.out.println(sourceCollection.toString());
        for(int i=0;i<priorities.size();i++){
           String tablename= priorities.get(i).getTablename();
            System.out.println(priorities.toString());
           for(int j=0;j<sources.size();j++){
               String comptable = sources.get(j).getTablename().toUpperCase();
            if(tablename.toUpperCase().equals(comptable)){
                String compcol =  sources.get(j).getColumnname().toUpperCase();
                for(int k=0;k<targets.size();k++){
                   // if(compcol.equals(targets.get(k).getColumnname().toUpperCase())){
                        List list =  FuzzySearch.extractAll(targets.get(k).getColumnname().toUpperCase(),sources, x -> x.getColumnname().toUpperCase());
                        //list.stream().
                        //FuzzySearch.
                        System.out.println(compcol+"--"+list)  ;
                        output = new Output();
                        output.setTargettable(targets.get(k).getTablename());
                        output.setTargetcolumn(targets.get(k).getColumnname());
                        output.setMatchedtable(tablename);
                        output.setMatchedcolumn(compcol);
                        output.setPercentage(list.toString());
                        output.setPriority(""+priorities.get(i).getPriority());
                        outputList.add(output);

                   // }

                }

            }
           }

        }


        return outputList;
    }
}
