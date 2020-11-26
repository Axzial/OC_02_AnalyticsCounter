package com.hemebiotech.analytics.writer;

import com.hemebiotech.analytics.model.SymptomFileData;

import java.util.List;

/**
 * Anything that will write symptoms
 */
public interface ISymptomWriter {

    /**
     * Write symptoms to a result file
     * @param rawSymptomFileData is a {@link List} of {@link SymptomFileData}.
     * @param resultName is the file result name.
     */
    void write(List<SymptomFileData> rawSymptomFileData, String resultName);
}
