package com.hemebiotech.analytics;

import com.hemebiotech.analytics.objects.RawSymptomFileData;
import com.hemebiotech.analytics.objects.SymptomFileData;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Used to count symptoms,
 * convert a RawSymptomFileData to a SymptomFileData (sorted)
 */
public class SymptomCounter {

    public SymptomCounter(){}

    /**
     *
     * @param rawSymptomFileDataList raw file data list
     * @return sorted filedata list
     */
    public ArrayList<SymptomFileData> convertCount(ArrayList<RawSymptomFileData> rawSymptomFileDataList){

        ArrayList<SymptomFileData> SymptomFileDataArrayList =  new ArrayList<SymptomFileData>();

        for (RawSymptomFileData rawSymptomFileData : rawSymptomFileDataList){
            TreeMap<String, Integer> sympMap = new TreeMap<>();
            for (String s : rawSymptomFileData.getRawSympList()){
                sympMap.put(s, sympMap.getOrDefault(s, 0) + 1);
            }
            SymptomFileData sfd = new SymptomFileData(rawSymptomFileData.getTitle(), sympMap);
            SymptomFileDataArrayList.add(sfd);
        }

        return SymptomFileDataArrayList;

    }

}
