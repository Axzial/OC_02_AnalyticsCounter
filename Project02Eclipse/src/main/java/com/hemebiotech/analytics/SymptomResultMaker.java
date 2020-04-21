package com.hemebiotech.analytics;

import com.hemebiotech.analytics.objects.SymptomFileData;

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

    public SymptomResultMaker(){}

    /**
     * Create the result file from the SymptomFileData list
     * @param rawSymptomFileData list
     */
    public void createFile(ArrayList<SymptomFileData> rawSymptomFileData, String resultName){
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
        }
        catch (IOException e) {
            symptomUtils.errorShutdown(5, "Could not create result file, shuting down");
        }
    }

}
