package com.hemebiotech.analytics;

import com.hemebiotech.analytics.datamanager.SymptomCounter;
import com.hemebiotech.analytics.filemanager.SymptomFileManager;
import com.hemebiotech.analytics.objects.RawSymptomFileData;
import com.hemebiotech.analytics.objects.SymptomFileData;
import com.hemebiotech.analytics.resultmaker.SymptomResultMaker;
import com.hemebiotech.analytics.sourcereaders.SymptomFileReader;
import com.hemebiotech.analytics.utils.SymptomUtils;
import io.vavr.collection.List;

import java.io.File;
import java.util.ArrayList;

public class AnalyticsCounter {

    SymptomFileManager symptomFileManager =  new SymptomFileManager();
    SymptomCounter symptomCounter = new SymptomCounter();
    SymptomUtils symptomUtils =  new SymptomUtils();

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
        new SymptomResultMaker(dataList);
    }
}
