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
     * Constructor
     * @param args are the args received from main
     */
    public AnalyticsCounter(String[] args){
        filename = SymptomUtils.getResultFileNameFromArgs(args);
        sources = SymptomUtils.getSourcesFromArgs(args);
    }

    /**
     * App starter, executing all needed tasks
     * 1 - Getting a list of files from args
     * 2 - Getting a raw list of symptoms in files
     * 3 - Getting a ordered and counted list of symptoms.
     * 4 - Writing to file results...
     */
    public void start(){
        List<File> files = symptomFileManager.getFilesFromArgs(sources);
        List<RawSymptomFileData> rawFileData = new SymptomFileReader(files).getSymptoms();
        List<SymptomFileData> dataList = symptomCounter.convertCount(rawFileData);
        symptomResultWriter.write(dataList, filename);
    }
}
