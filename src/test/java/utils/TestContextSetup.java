package utils;

import pageobjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

    public TestBase testBase;
    public PageObjectManager pageObjectManager;
    public GenericUtils genericUtils;
    public String generatedUsername;
    public String password;
    public String homePageBookTitle;
    public String bookDetailsPageBookTitle;
    public String wishlistPageBookTitle;

    public TestContextSetup () throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }
}
