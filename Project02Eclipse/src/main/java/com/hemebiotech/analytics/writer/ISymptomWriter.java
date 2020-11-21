package com.hemebiotech.analytics.writer;

import com.hemebiotech.analytics.model.SymptomFileData;

import java.util.List;

public interface ISymptomWriter {

    /**
     * Create the result file from the SymptomFileData list
     * @param rawSymptomFileData list
     */
    void write(List<SymptomFileData> rawSymptomFileData, String resultName);
}
