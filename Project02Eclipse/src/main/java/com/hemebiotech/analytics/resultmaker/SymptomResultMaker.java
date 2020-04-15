package com.hemebiotech.analytics.resultmaker;

import com.hemebiotech.analytics.AnalyticsCounter;
import com.hemebiotech.analytics.objects.SymptomFileData;
import com.hemebiotech.analytics.utils.SymptomUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Used to create the result file
 */
public class SymptomResultMaker {

    SymptomUtils symptomUtils =  new SymptomUtils();

    private String resultName = AnalyticsCounter.filename;

    /**
     * Create the result file from the SymptomFileData list
     * @param rawSymptomFileData list
     */
    public SymptomResultMaker(ArrayList<SymptomFileData> rawSymptomFileData){
        try {
            File file =  new File(resultName);
            FileWriter fileWriter = new FileWriter(file);
            for (SymptomFileData sfd : rawSymptomFileData){
                fileWriter.write(sfd.getTitle() + "\n");
                for (Map.Entry<String, Integer> s : sfd.getSympList().entrySet()){
                    fileWriter.write(s.getKey() + ": " + s.getValue() + "\n");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            symptomUtils.errorShutdown(5, "Could not create result file, shuting down");
        }
    }

}
