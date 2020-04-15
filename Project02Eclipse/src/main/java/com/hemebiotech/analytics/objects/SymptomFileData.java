package com.hemebiotech.analytics.objects;

import java.util.TreeMap;

/**
 * Object that contain a sorted list of symptoms
 */
public class SymptomFileData {

    private String title;
    private TreeMap<String, Integer> sympList;

    /**
     * Class constructor
     * @param title name of file
     * @param sympList sorted symptoms map
     */
    public SymptomFileData(String title, TreeMap<String, Integer> sympList){
        this.title = title;
        this.sympList = sympList;
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
    public TreeMap<String, Integer> getSympList() {
        return sympList;
    }

}
