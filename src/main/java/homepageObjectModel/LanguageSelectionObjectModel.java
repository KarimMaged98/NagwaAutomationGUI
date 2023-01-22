package homepageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The LanguageSelectionObjectModel page is used for identification the page locators and possible actions
 */

public class LanguageSelectionObjectModel {
    //*** Variables ***//
    private WebDriver driver;

    //*** Constructor ***//
    public LanguageSelectionObjectModel(WebDriver driver) {
       this.driver=driver;
    }

    //*** Locators ***//

    /**
     * This is the locator of the "English" language button
     * @return The Xpath of the English button
     */
    private By englishLang_button() {
        return By.xpath("//a[@href='/en/']");
    }

    //*** Keywords and Actions ***//
    /**
     * This method is used for choosing the English language as a Nagwa's website language
     */
    public void clickOnEnglishBtn(){
        driver.findElement(englishLang_button()).click();
    }

}
