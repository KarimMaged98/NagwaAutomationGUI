package UserScenarios;

import homepageObjectModel.HomepageObjectModel;
import homepageObjectModel.LanguageSelectionObjectModel;
import homepageObjectModel.SearchResultObjectModel;
import homepageObjectModel.TheAdditionSymbolObjectModel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Scenario {

    //*** Variables ***//
    public static WebDriver driver;
    LanguageSelectionObjectModel languageSelectionObjectMode;
    HomepageObjectModel homepageObjectModel;
    SearchResultObjectModel searchResultObjectModel;
    TheAdditionSymbolObjectModel theAdditionSymbolObjectModel;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.nagwa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void beforeClass() {
        //Instantiation of instances from POMs
        languageSelectionObjectMode = new LanguageSelectionObjectModel(driver);
        homepageObjectModel = new HomepageObjectModel(driver);
        searchResultObjectModel = new SearchResultObjectModel(driver);
        theAdditionSymbolObjectModel = new TheAdditionSymbolObjectModel(driver);
    }

    @Test
    public void TestScenario() {
        //Select the language of Nagwa's website to be English
        languageSelectionObjectMode.clickOnEnglishBtn();
        Assert.assertEquals(homepageObjectModel.getNagwaLogo(),true);
        //Click on the search icon
        homepageObjectModel.clickOnSearchBtn();
        //Enter "addition" in the search bar
        homepageObjectModel.writeInSearchBtn();
        //Click to search
        homepageObjectModel.clickOnSearchBtnV2();
        Assert.assertEquals(searchResultObjectModel.getTextOfSearchResult(),"The Addition Symbol");
        //Click on the second result
        searchResultObjectModel.clickOnTheSecondResult();
        //Click on the Work Sheet section
        theAdditionSymbolObjectModel.clickOnWorkSheetSection();
        Assert.assertEquals(theAdditionSymbolObjectModel.theTitleOfThePage("Addition"),true);
        //Print the number of the questions
        theAdditionSymbolObjectModel.printTheNumberOfQuestions();
    }

    @AfterTest
    public void afterTest() {
        //To close the Chrome browser
        driver.quit();
    }

}
