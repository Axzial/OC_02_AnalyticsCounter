package com.hemebiotech.analytics.filemanager;

import com.hemebiotech.analytics.Main;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Used to get a list of files from args
 */
public class SymptomFileManager {

    private Logger logger = Main.getLogger();

    public SymptomFileManager(){}

    /**
     * Method to get a list of files from args
     * @param args path to files
     * @return a list of all files from args
     */
    public List<File> getFilesFromArgs(io.vavr.collection.List<String> args){

        List<File> fileList =  new ArrayList<>();

        for (String s : args){ //Get all args
            if (fileExists(s)){ //Check if file exists
                fileList.add(new File(s));
            }
            else { //Skip the file
                logger.error("Can't find file matching this path: " + s + ", (SKIPPING)");
            }
        }

        return fileList;
    }

    /**
     * Check if a file exists
     * @param path absolute path of the file
     * @return boolean
     */
    public boolean fileExists(String path){
        File file = new File(path);
        return file.exists();
    }

}
