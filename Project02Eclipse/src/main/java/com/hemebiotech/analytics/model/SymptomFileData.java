package com.hemebiotech.analytics.model;

import java.util.Map;

/**
 * Contains a counted and sorted map of symptoms but also a file name.
 */
public class SymptomFileData {

    private String title;
    private Map<String, Long> sympList;

    /**
     * Constructor
     * @param title name of the current file.
     * @param sympMap sorted symptoms map.
     */
    public SymptomFileData(String title, Map<String, Long> sympMap){
        this.title = title;
        this.sympList = sympMap;
    }

    /**
     * Name of the current file
     * @return the name defined
     */
    public String getTitle() {
        return title;
    }

    /**
     * Symptoms map
     * @return sorted {@link Map} of symptoms and amounts of them
     */
    public Map<String, Long> getSympList() {
        return sympList;
    }

}
