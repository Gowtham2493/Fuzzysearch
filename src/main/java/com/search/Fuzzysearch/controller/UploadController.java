package com.search.Fuzzysearch.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.search.Fuzzysearch.entity.*;
import com.search.Fuzzysearch.service.UploadService;
import com.search.Fuzzysearch.service.UploadServiceImp;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

import org.json.JSONObject;

@RestController
@RequestMapping("/api")
public class UploadController {

    UploadService service = new UploadServiceImp();
    @PostMapping("/upload-source-file")
    public String uploadSourceFile(@RequestParam("file") MultipartFile file, Model model) {

        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            // parse CSV file to create a list of objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<Source> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Source.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<Source> users = csvToBean.parse();
                System.out.println(users.toString());
                // save users list on model
                model.addAttribute("users", users);
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return "file-upload-status";
    }
    @PostMapping("/upload-target-file")
    public String uploadTargetFile(@RequestParam("file") MultipartFile file, Model model) {

        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            // parse CSV file to create a list of objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<Target> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Target.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<Target> users = csvToBean.parse();

                // save users list on model
                model.addAttribute("users", users);
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return "file-upload-status";
    }
    @PostMapping("/upload-priority-file")
    public String uploadPriorityFile(@RequestParam("file") MultipartFile[] files, Model model) {

        // validate file
        for (MultipartFile file:
            files ) {


            if (file.isEmpty()) {
                model.addAttribute("message", "Please select a CSV file to upload.");
                model.addAttribute("status", false);
            } else {

                // parse CSV file to create a list of objects
                try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                    // create csv bean reader
                    CsvToBean<Priority> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Priority.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

                    // convert `CsvToBean` object to list of users
                    List<Priority> users = csvToBean.parse();

                    // save users list on model
                    model.addAttribute("users", users);
                    model.addAttribute("status", true);

                } catch (Exception ex) {
                    model.addAttribute("message", "An error occurred while processing the CSV file.");
                    model.addAttribute("status", false);
                }
            }
        }

        return "file-upload-status";
    }

    @PostMapping(value ="/downloadFile", consumes = "multipart/form-data",produces= MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public Map<String, Object> runFile (@RequestParam("file") MultipartFile[] files,@RequestParam("threshold") String threshold) throws JSONException {
        Map<String, Object> jsonObject = new HashMap();
        List<Output> output = new ArrayList<>();
        List<Source> sources = new ArrayList<>();
        List<Target> targets = new ArrayList<>();
        List<Priority> priorities = new ArrayList<>();
        List<Reinforcement> reinforcements = new ArrayList<>();
        for (MultipartFile file:
                files ) {

    System.out.println(file.getOriginalFilename());
            if (file.isEmpty()) {
                jsonObject.put("data",output);
                return jsonObject;

            } else {

                // parse CSV file to create a list of objects
                try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                if(file.getOriginalFilename().contains("source")) {
                    // create csv bean reader
                    CsvToBean<Source> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Source.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

                    // convert `CsvToBean` object to list of users
                    sources= csvToBean.parse();
                }
                else if(file.getOriginalFilename().contains("target")) {
                    // create csv bean reader
                    CsvToBean<Target> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Target.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

                    // convert `CsvToBean` object to list of users
                    targets= csvToBean.parse();
                }
                  else  if(file.getOriginalFilename().contains("priority")) {
                        // create csv bean reader
                        CsvToBean<Priority> csvToBean = new CsvToBeanBuilder(reader)
                                .withType(Priority.class)
                                .withIgnoreLeadingWhiteSpace(true)
                                .build();

                        // convert `CsvToBean` object to list of users
                        priorities= csvToBean.parse();
                    }

                else  if(file.getOriginalFilename().contains("reinforce")) {
                    // create csv bean reader
                    CsvToBean<Reinforcement> csvToBean = new CsvToBeanBuilder(reader)
                            .withType(Reinforcement.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

                    // convert `CsvToBean` object to list of users
                    reinforcements= csvToBean.parse();
                }


                } catch (Exception ex) {

                }

            }
        }
        if(reinforcements.size() > 0){
            sources = service.combineReinfSrc(sources,reinforcements);
        }

     // output=  service.runLogic(sources,targets,priorities,threshold);
        Map<String,Object> objectMap=service.runLogic(sources,targets,priorities,threshold);
       // jsonObject.put("data",output);

    return objectMap;

    }

}
