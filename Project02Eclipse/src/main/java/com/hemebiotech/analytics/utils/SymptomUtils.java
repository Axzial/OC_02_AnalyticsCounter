package com.hemebiotech.analytics.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class SymptomUtils {

    public static final int MISSING_ARGUMENT = 1;
    public static final int PERSISTENCE_PROBLEM = 5;
    private static Logger logger = LoggerFactory.getLogger(SymptomUtils.class);


    /**
     * Get sources from args
     * Using checkArgs
     * @param args raw sources
     */
    public static List<String> getSourcesFromArgs(String[] args){
        if (!checkArgs(args)){
            errorShutdown(MISSING_ARGUMENT, "Missing Arguments: <resultfilename> <sourcefile>");
        }
        LinkedList<String> result = new LinkedList<>(Arrays.asList(args));
        result.removeFirst();
        return result;
    }

    /**
     * Get result file name from args
     * Using checkArgs
     * @param args raw sources
     */
    public static String getResultFileNameFromArgs(String[] args){
        String s = "default";
        if (!checkArgs(args)){
            errorShutdown(MISSING_ARGUMENT, "Missing Arguments: <resultfilename> <sourcefile>");
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
    public static boolean checkArgs(String[] args){
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
    public static void errorShutdown(int status, String message){
        logger.error(message);
        logger = null;
        Runtime.getRuntime().exit(status);
    }

}
