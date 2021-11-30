package com.search.Fuzzysearch.service;

import com.opencsv.CSVWriter;
import com.search.Fuzzysearch.entity.*;
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
    //public List<Output> runLogic(List<Source> sources, List<Target> targets, List<Priority> priorities,String thresholds) {
    public Map<String,Object> runLogic(List<Source> sources, List<Target> targets, List<Priority> priorities,String thresholds){
        Map<String,Object> map=new HashMap<>();
        Collection<Source> sourceCollection = sources;
        Collections.sort(priorities, Comparator.comparingInt(p -> p.getPriority()));
        List<Output> outputList = new ArrayList<Output>();
        List<Unmatched> unmatcheds = new ArrayList<Unmatched>();
        Output output = new Output();
        Unmatched unmatched = new Unmatched();
        int threshold=90;
        if(thresholds!=null && thresholds!="") {
        	threshold = Integer.parseInt(thresholds);
        }
        System.out.println(sourceCollection.toString());
        for(int i=0;i<priorities.size();i++){
           String tablename= priorities.get(i).getTablename();
            System.out.println(priorities.toString());
           for(int j=0;j<sources.size();j++){
               String comptable = sources.get(j).getTableName().toUpperCase();
            if(tablename.toUpperCase().equals(comptable)){
                String compcol =  sources.get(j).getColumnName().toUpperCase();
                String compdesc = sources.get(j).getColumnDesc();
                for(int k=0;k<targets.size();k++){
                   // if(compcol.equals(targets.get(k).getColumnname().toUpperCase())){
                        List list =  FuzzySearch.extractAll(targets.get(k).getColumnName().toUpperCase(),sources, x -> x.getColumnName().toUpperCase());
                    //To do get column desc and column tag and do fuzzysearch and compare among these three lists and show greater score
                    String scoreCol = splitscore(list,compcol).trim();
                    if(Integer.parseInt(scoreCol) < threshold && Integer.parseInt(scoreCol) > 0){
                        String compDesc =  sources.get(j).getColumnDesc().toUpperCase();
                        List list1 =  FuzzySearch.extractAll(targets.get(k).getColumnDesc().toUpperCase(),sources, x -> x.getColumnDesc().toUpperCase());
                        output = new Output();
                        String scoreDesc = splitscore(list1,compDesc).trim();
                        if(Integer.parseInt(scoreDesc) < threshold && Integer.parseInt(scoreDesc) > 0) {
                            String compTag =  sources.get(j).getColumnTag().toUpperCase();
                            List list2 =  FuzzySearch.extractAll(targets.get(k).getColumnTag().toUpperCase(),sources, x -> x.getColumnTag().toUpperCase());

                            String scoreTag = splitscore(list2,compTag).trim();
                            if(Integer.parseInt(scoreTag) > 0) {
                                output = new Output();
                                output.settTbName(targets.get(k).getTableName());
                                output.settColName(targets.get(k).getColumnName());
                                output.settDesc(targets.get(k).getColumnDesc());
                                output.setsTbName(tablename);
                                output.setsColName(compcol);
                                output.setsDesc(compdesc);
                                output.setPercentage(scoreTag);
                                output.setPriority("" + priorities.get(i).getPriority());
                                outputList.add(output);
                            }
                        }
                        else if(!scoreDesc.equals("0")){
                            output = new Output();
                            output.settTbName(targets.get(k).getTableName());
                            output.settColName(targets.get(k).getColumnName());
                            output.settDesc(targets.get(k).getColumnDesc());
                            output.setsTbName(tablename);
                            output.setsColName(compcol);
                            output.setsDesc(compdesc);
                            output.setPercentage(scoreDesc);
                            output.setPriority("" + priorities.get(i).getPriority());
                            outputList.add(output);
                        }
                    }
                    else {

                        if(!scoreCol.equals("0")) {
                            output = new Output();
                            output.settTbName(targets.get(k).getTableName());
                            output.settColName(targets.get(k).getColumnName());
                            output.settDesc(targets.get(k).getColumnDesc());
                            output.setsTbName(tablename);
                            output.setsColName(compcol);
                            output.setsDesc(compdesc);
                            output.setPercentage(scoreCol);
                            output.setPriority("" + priorities.get(i).getPriority());
                            outputList.add(output);
                        }
                        else {
                        	unmatched = new Unmatched();
                        	unmatched.setTbName(targets.get(k).getTableName());
                        	unmatched.setColName(targets.get(k).getColumnName());
                        	unmatched.setDesc(targets.get(k).getColumnDesc());
                        	unmatched.setTags(targets.get(k).getColumnTag());
                        	unmatcheds.add(unmatched);
                        	//output.setUnmatched(unmatcheds);
                        	//outputList.add(output);

                        }
                        
                    }


                   // }

                }


            }
           }

        }
        // add one more file reinforcement file
        // To do how to check out of three priority table which one has the highest percentage

        // To do sort output table with desc
      // Collections.sort(outputList, Comparator.comparingInt(p -> Integer.parseInt(p.getPercentage())));
        //Collections.sort(outputList, Collections.reverseOrder());

        map.put("data",outputList);
        map.put("unMatchedTargets",unmatcheds);
        return map;
    }

    public String splitscore(List list,String matchedcol){
        String score = "0";
       for(int i=0;i<list.size();i++){
           String temp = list.get(i).toString().replace("(","").replace(")","");
           String arj[] = temp.replace("string:","").replace("score:","").replace("index:","").trim().split(",");
           if(arj[0].trim().equals(matchedcol)){
                  score = arj[1];
              }

       }

        return score;
    }

    @Override
    public List<Source> combineReinfSrc(List<Source> sources, List<Reinforcement> reinforcements) {
        System.out.println("sources = " + sources +"\n"+"reinforcements = " + reinforcements);
       for(int i=0;i<reinforcements.size();i++){
            for(int j=0;j<sources.size();j++){
                if(reinforcements.get(i).getSrcTableName().equals(sources.get(j).getTableName() )
                        && reinforcements.get(i).getSrcColName().equals(sources.get(j).getColumnName())){
                    sources.get(j).setColumnTag(sources.get(j).getColumnTag() + ", " + reinforcements.get(i).getColumnDesc());
                }
            }
        }
        return sources;
    }
}

