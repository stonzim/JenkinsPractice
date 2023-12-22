package utils;

import page_objects.PageObjectFactory;
import java.io.IOException;

public class TestContextSetup {
    public TestBase testBase;
    public PageObjectFactory pageObjectFactory;
    public GeneralTestUtils generalTestUtils;
    public String testStringVariable;
    public int testIntVariable;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectFactory = new PageObjectFactory(testBase.WebDriverManager());
        generalTestUtils = new GeneralTestUtils(testBase.WebDriverManager());
    }
}
