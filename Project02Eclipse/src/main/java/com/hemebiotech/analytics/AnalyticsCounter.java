package com.hemebiotech.analytics;

import com.hemebiotech.analytics.counter.SymptomCounter;
import com.hemebiotech.analytics.model.RawSymptomFileData;
import com.hemebiotech.analytics.model.SymptomFileData;
import com.hemebiotech.analytics.reader.SymptomFileReader;
import com.hemebiotech.analytics.utils.SymptomUtils;
import com.hemebiotech.analytics.writer.SymptomResultWriter;

import java.io.File;
import java.util.List;

public class AnalyticsCounter {

    SymptomFileManager symptomFileManager =  new SymptomFileManager();
    SymptomCounter symptomCounter = new SymptomCounter();
    SymptomResultWriter symptomResultWriter =  new SymptomResultWriter();

    public static String filename;

    public static List<String> sources;

    /**
     * Class constructor
     * @param args are the args received from main
     */
    public AnalyticsCounter(String[] args){
        filename = SymptomUtils.getResultFileNameFromArgs(args);
        sources = SymptomUtils.getSourcesFromArgs(args);
    }

    /**
     * App launcher, executing all needed tasks
     */
    public void start(){
        List<File> files = symptomFileManager.getFilesFromArgs(sources);
        List<RawSymptomFileData> rawFileData = new SymptomFileReader(files).getSymptoms();
        List<SymptomFileData> dataList = symptomCounter.convertCount(rawFileData);
        symptomResultWriter.write(dataList, filename);
    }
}
