package com.hemebiotech.analytics.counter;

import com.hemebiotech.analytics.model.RawSymptomFileData;
import com.hemebiotech.analytics.model.SymptomFileData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Used to count symptoms,
 * convert a RawSymptomFileData to a SymptomFileData (sorted)
 */
public class SymptomCounter {

    private final Logger LOGGER = LoggerFactory.getLogger(SymptomCounter.class);


    /**
     * Used to convert a {@link RawSymptomFileData} list to a {@link SymptomFileData} list.
     * @param rawSymptomFileDataList is the {@link RawSymptomFileData} list.
     * @return a {@link SymptomFileData} list.
     */
    public List<SymptomFileData> convertCount(List<RawSymptomFileData> rawSymptomFileDataList){
        return rawSymptomFileDataList.stream()
                .map(this::getSymptomFileData)
                .collect(Collectors.toList());
    }

    /**
     * Used to convert a single {@link RawSymptomFileData} to a {@link SymptomFileData}
     * @param rawSymptomFileData is a single {@link RawSymptomFileData}.
     * @return a single {@link SymptomFileData}.
     */
    private SymptomFileData getSymptomFileData(RawSymptomFileData rawSymptomFileData) {
        LOGGER.info("comptage pour le fichier {}", rawSymptomFileData.getTitle());
        Map<String, Long> sympMap = rawSymptomFileData.getRawSympList().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new SymptomFileData(rawSymptomFileData.getTitle(), sympMap);
    }

}
