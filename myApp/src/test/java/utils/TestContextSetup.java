package utils;

import page_objects.PageObjectFactory;

public class TestContextSetup {
    public TestBase testBase;
    public PageObjectFactory pageObjectFactory;
    public GeneralTestUtils generalTestUtils;
    public String testVariable;

    public TestContextSetup() {
        testBase = new TestBase();
        pageObjectFactory = new PageObjectFactory(testBase.WebDriverManager());
        generalTestUtils = new GeneralTestUtils(testBase.WebDriverManager());
    }
}
