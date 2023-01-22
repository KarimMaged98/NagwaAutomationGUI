package homepageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The SearchResultObjectModel page is used for identification the page locators and possible actions
 */

public class SearchResultObjectModel {

    //*** Variables ***//
    private WebDriver driver;

    //*** Constructor ***//
    public SearchResultObjectModel(WebDriver driver) {
        this.driver = driver;
    }

    //*** Locators ***//
    /**
     * This is the locator of the second item of the search results
     * @return
     */
    private By second_search_result() {
        return By.xpath("//a[normalize-space()='The Addition Symbol']");
    }

    //*** Keywords and Actions ***//
    /**
     * This method is used for clicking on the second item of the search results
     */
    public void clickOnTheSecondResult() {
        driver.findElement(second_search_result()).click();
    }

    /**
     * This method gets the Text of the search result item, will be used in assertions
     * @return It returns the text of the searched result
     */
    public String getTextOfSearchResult(){
        return driver.findElement(second_search_result()).getText();
    }

}
