package com.hemebiotech.analytics.reader;

import com.hemebiotech.analytics.exception.ReaderException;
import com.hemebiotech.analytics.model.RawSymptomFileData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read a list of files and return a list of RawSymptomFileData
 */
public class SymptomFileReader implements ISymptomReader{

    private Logger logger = LoggerFactory.getLogger(SymptomFileReader.class);

    private List<File> filelist;

    /**
     * Class constructor
     * @param files list of files from the file manager
     */
    public SymptomFileReader(List<File> files){
        filelist = files;
    }

    /**
     * Convert files to SymptomFileData objects with the raw method (rawlist)
     * @return a raw listing of all SymptomFileData obtained from a data source, duplicates are possible/probable
     */
    @Override
    public List<RawSymptomFileData> getSymptoms() {

        List<RawSymptomFileData> symptomsFileDataList = new ArrayList<>();

        for (File file : filelist){

            List<String> symptomsRaw = new ArrayList<>();

            try(BufferedReader bufferedReader =  new BufferedReader(new FileReader(file))) {
                String line = bufferedReader.readLine();
                while (line != null){
                    symptomsRaw.add(line);
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                logger.error("Error while reading: " + file.getName() + ", (SKIPPING)");
                throw new ReaderException("Error while reading: " + file.getName() + ", (SKIPPING)", e);
            }

            RawSymptomFileData rawSymptomFileData = new RawSymptomFileData(file.getName(), symptomsRaw);
            symptomsFileDataList.add(rawSymptomFileData);

        }
        return symptomsFileDataList;
    }

}
