package com.hemebiotech.analytics.objects;

import java.util.ArrayList;

/**
 * Object that contain a raw list of symptoms
 */
public class RawSymptomFileData {

    private String title;
    private ArrayList<String> rawSympList;

    /**
     * Class constructor
     * @param title name of file
     * @param rawSympList raw symptoms list
     */
    public RawSymptomFileData(String title, ArrayList<String> rawSympList){
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
    public ArrayList<String> getRawSympList() {
        return rawSympList;
    }

}
