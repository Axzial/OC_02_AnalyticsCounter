import com.hemebiotech.analytics.utils.SymptomUtils;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SymptomUtilsTest {

    @Test
    public void testGetSourcesFromArgs(){
        String fileName = "filename";
        String[] args = {fileName, "source1", "source2", "source3"};
        List<String> argsList = new SymptomUtils().getSourcesFromArgs(args);
        assertFalse(argsList.contains(fileName));
    }

    @Test
    public void testGetFileNameFromArgs(){
        String fileName = "filename";
        String[] args = {fileName, "source1", "source2", "source3"};
        String resultFileName = new SymptomUtils().getResultFileNameFromArgs(args);
        assertEquals(fileName, resultFileName);
    }

    @Test
    public void testCheckArgs(){
        SymptomUtils symptomUtils =  new SymptomUtils();
        String[] args = {"1"};
        assertFalse(symptomUtils.checkArgs(args));
        String[] args2 = {"1", "2"};
        assertTrue(symptomUtils.checkArgs(args2));
    }
}
