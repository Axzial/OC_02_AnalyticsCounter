package com.hemebiotech.analytics;

import com.hemebiotech.analytics.objects.RawSymptomFileData;
import com.hemebiotech.analytics.objects.SymptomFileData;
import com.hemebiotech.analytics.sourcereaders.SymptomFileReader;
import io.vavr.collection.List;

import java.io.File;
import java.util.ArrayList;

public class AnalyticsCounter {

    SymptomFileManager symptomFileManager =  new SymptomFileManager();
    SymptomCounter symptomCounter = new SymptomCounter();
    SymptomUtils symptomUtils =  new SymptomUtils();
    SymptomResultMaker symptomResultMaker =  new SymptomResultMaker();

    public static String filename;

    public static List<String> sources;

    /**
     * Class constructor
     * @param args are the args received from main
     */
    public AnalyticsCounter(String[] args){
        filename = symptomUtils.getResultFileNameFromArgs(args);
        sources = symptomUtils.getSourcesFromArgs(args);
    }

    /**
     * App launcher, executing all needed tasks
     */
    public void launcher(){
        java.util.List<File> files = symptomFileManager.getFilesFromArgs(sources);
        ArrayList<RawSymptomFileData> rawFileData = new SymptomFileReader(files).getSymptoms();
        ArrayList<SymptomFileData> dataList = symptomCounter.convertCount(rawFileData);
        symptomResultMaker.createFile(dataList, filename);
    }
}
