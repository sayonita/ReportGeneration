package testsample;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import utils.xml.XmlUtils;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class Sample {

    private final static String TAG_SCREEN = "screen";
    private final static String TAG_ERROR_CODE = "errorCode";
    private final static String TAG_SCREEN_EXPECTED_VALUE_ERROR_CODE="0";
    private final static String TAG_SCREEN_EXPECTED_VALUE_SMALL ="small";
    private final static String TAG_SCREEN_EXPECTED_VALUE_LARGE ="large";
    private final static String XML_FILE_PATH = "./src/test/resources/testfile/test.xml";

    @Test(priority = 1, description = "Verify error-code tag-value")
    public void verifyErrorCode() throws IOException, SAXException, ParserConfigurationException {
        XmlUtils.verifyAllNodeContainsValue(XML_FILE_PATH, TAG_ERROR_CODE, TAG_SCREEN_EXPECTED_VALUE_ERROR_CODE);
    }

    @Test(priority = 1, description = "Verify small screen tag-value")
    public void verifySmallScreenTag() throws IOException, SAXException, ParserConfigurationException {
        XmlUtils.verifyNodeContainsValue(XML_FILE_PATH, TAG_SCREEN, TAG_SCREEN_EXPECTED_VALUE_SMALL);
    }

    @Test(priority = 1, description = "Verify large screen tag-value")
    public void verifyLargeScreenTag() throws IOException, SAXException, ParserConfigurationException {
        XmlUtils.verifyNodeContainsValue(XML_FILE_PATH, TAG_SCREEN, TAG_SCREEN_EXPECTED_VALUE_LARGE);
    }

}
