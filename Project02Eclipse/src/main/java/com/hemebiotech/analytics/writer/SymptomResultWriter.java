package com.hemebiotech.analytics.writer;

import com.hemebiotech.analytics.exception.WriterException;
import com.hemebiotech.analytics.model.SymptomFileData;
import com.hemebiotech.analytics.utils.SymptomUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create the result file
 */
public class SymptomResultWriter implements ISymptomWriter {

    /**
     * Write to a txt file...
     * @param rawSymptomFileData is a {@link List} of {@link SymptomFileData}.
     * @param resultName is the file result name.
     */
    @Override
    public void write(List<SymptomFileData> rawSymptomFileData, String resultName){

        File file =  new File(resultName);
        try ( FileWriter fileWriter = new FileWriter(file)) {
            for (SymptomFileData sfd : rawSymptomFileData){
                fileWriter.write(sfd.getTitle() + "\n");
                Map<String, Long> symptoms = sfd.getSympList();
                for (String symptom : symptoms.keySet().stream().sorted().collect(Collectors.toList())) {
                    fileWriter.write(symptom + ": " + symptoms.get(symptom) + "\n");
                }
                fileWriter.write("\n");
            }
        }
        catch (IOException e) {
            SymptomUtils.errorShutdown(SymptomUtils.PERSISTENCE_PROBLEM, "Could not create result file, shuting down");
            throw new WriterException("Could not create result file, shuting down", e);
        }
    }
}
