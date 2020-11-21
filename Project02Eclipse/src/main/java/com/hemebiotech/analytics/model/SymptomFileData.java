package com.hemebiotech.analytics.model;

import java.util.Map;

/**
 * Object that contain a sorted list of symptoms
 */
public class SymptomFileData {

    private String title;
    private Map<String, Long> sympList;

    /**
     * Class constructor
     * @param title name of file
     * @param sympMap sorted symptoms map
     */
    public SymptomFileData(String title, Map<String, Long> sympMap){
        this.title = title;
        this.sympList = sympMap;
    }

    /**
     * Name of file
     * @return the name defined
     */
    public String getTitle() {
        return title;
    }

    /**
     * Symptoms map
     * @return sorted map of symptoms
     */
    public Map<String, Long> getSympList() {
        return sympList;
    }

}
