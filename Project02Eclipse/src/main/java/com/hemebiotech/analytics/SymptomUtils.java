package com.hemebiotech.analytics;

import io.vavr.collection.List;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class SymptomUtils {

    private Logger logger = Main.getLogger();

    /**
     * Utils class constructor
     */
    public SymptomUtils(){}

    /**
     * Get sources from args
     * Using checkArgs
     * @param args raw sources
     */
    public List<String> getSourcesFromArgs(String[] args){
        if (!checkArgs(args)){
            errorShutdown(1, "Missing Arguments: <resultfilename> <sourcefile>");
        }
        return List.ofAll(Arrays.asList(args)).drop(1);
    }

    /**
     * Get result file name from args
     * Using checkArgs
     * @param args raw sources
     */
    public String getResultFileNameFromArgs(String[] args){
        String s = "default";
        if (!checkArgs(args)){
            errorShutdown(1, "Missing Arguments: <resultfilename> <sourcefile>");
        }
        try {
            s = args[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * Check if args of main class are good
     * @param args raw string args
     * @return boolean
     */
    public boolean checkArgs(String[] args){
        if (args.length < 2){
            return false;
        }
        return true;
    }

    /**
     * Method used to shutdown program
     * @param status code for shutdown
     * @param message shutdown error
     */
    public void errorShutdown(int status, String message){
        logger.fatal(message);
        logger = null;
        Runtime.getRuntime().exit(status);
    }

}
