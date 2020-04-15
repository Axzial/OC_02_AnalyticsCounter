package com.hemebiotech.analytics;

import com.hemebiotech.analytics.utils.SymptomUtils;
import io.vavr.collection.List;

public class AnalyticsCounter {

    SymptomUtils symptomUtils =  new SymptomUtils();

    public static String filename;

    public static List<String> sources;

    /**
     * Class constructor
     * @param args are the args received from main
     */
    public AnalyticsCounter(String[] args){
        filename = symptomUtils.getResultFileNameFromArgs(args);
        sources = symptomUtils.getSourcesFromArgs(args);
    }

    /**
     * App launcher, executing all needed tasks
     */
    public void launcher(){

    }
}
