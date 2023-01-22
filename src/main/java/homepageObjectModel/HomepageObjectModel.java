package homepageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The HomepageObjectModel page is used for identification the homepage locators and possible actions
 */

public class HomepageObjectModel {
    //*** Variables ***//
    private WebDriver driver;

    //*** Constructor ***//
    public HomepageObjectModel(WebDriver driver) {
        this.driver=driver;
    }

    //*** Locators ***//
    /**
     * The locator of the search button
     * @return the Xpath of the search button
     */
    private By search_button() {
        return By.xpath("//button[@type='button']//child::i");
    }

    /**
     * The search bar field which we will write in it
     * @return the Xpath of the search bar field
     */
    private By searchBar_textBox() {
        return By.xpath("//input[@id='txt_search_query']");
    }

    /**
     * This is the same search icon after expanding on clicking on the search bar
     * @return the Xpath of the search button
     */
    private By search_button_v2(){
        return By.xpath("//button[@id='btn_global_search']//child::i");
    }

    /**
     * This is the logo of the website to assert if the website opened correctly
     * @return the Xpath of the website logo
     */
    private By nagwa_logo(){
        return By.xpath("//a[@title='Egypt']//img[@alt='Nagwa']");
    }

    //*** Keywords and Actions ***//
    /**
     * This method is used for choosing the English language as a Nagwa's website language
     */
    public void clickOnSearchBtn(){
        driver.findElement(search_button()).click();
    }

    /**
     * This method is used for writing "addition" in the search bar
     */
    public void writeInSearchBtn(){
        driver.findElement(searchBar_textBox()).sendKeys("addition");
    }

    /**
     * This method clicks on the search icon on the search bar
     */
    public void clickOnSearchBtnV2(){
        driver.findElement(search_button_v2()).click();
    }

    /**
     *This method checks the website logo visibility
     * @return
     */
    public Boolean getNagwaLogo(){
        return driver.findElement(nagwa_logo()).isDisplayed();
    }

}
