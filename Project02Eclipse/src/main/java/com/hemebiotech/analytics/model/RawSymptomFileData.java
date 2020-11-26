package com.hemebiotech.analytics.model;

import java.util.List;

/**
 * Contains a raw symptoms list but also a file name.
 */
public class RawSymptomFileData {

    private String title;
    private List<String> rawSympList;

    /**
     * Constructor
     * @param title is the name of the current {@link java.io.File}
     * @param rawSympList is a list of {@link String} containing all the syptoms of a file.
     */
    public RawSymptomFileData(String title, List<String> rawSympList){
        this.title = title;
        this.rawSympList = rawSympList;
    }

    /**
     * Name of the current file
     * @return the name defined
     */
    public String getTitle() {
        return title;
    }

    /**
     * Symptoms list as {@link String}
     * @return raw {@link List} of symptoms
     */
    public List<String> getRawSympList() {
        return rawSympList;
    }

}
