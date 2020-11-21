package com.hemebiotech.analytics.model;

import java.util.List;

/**
 * Object that contain a raw list of symptoms
 */
public class RawSymptomFileData {

    private String title;
    private List<String> rawSympList;

    /**
     * Class constructor
     * @param title name of file
     * @param rawSympList raw symptoms list
     */
    public RawSymptomFileData(String title, List<String> rawSympList){
        this.title = title;
        this.rawSympList = rawSympList;
    }

    /**
     * Name of file
     * @return the name defined
     */
    public String getTitle() {
        return title;
    }

    /**
     * Symptoms list
     * @return raw list of symptoms
     */
    public List<String> getRawSympList() {
        return rawSympList;
    }

}
