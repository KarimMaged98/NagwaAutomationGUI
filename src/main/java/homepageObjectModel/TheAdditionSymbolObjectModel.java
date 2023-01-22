package homepageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * The TheAdditionSymbolObjectModel page is used for identification the page locators and possible actions
 */

public class TheAdditionSymbolObjectModel {

    //*** Variables ***//
    private WebDriver driver;

    //*** Constructor ***//
    public TheAdditionSymbolObjectModel(WebDriver driver) {
        this.driver = driver;
    }

    //*** Locators ***//
    /**
     * This is the locator of the work sheet section
     * @return the xPath of the work sheet element
     */
    private By work_sheet_section() {
        return By.xpath("//div[@class='question-preview']");
    }

    /**
     * This is the locator of the questions of the work sheet
     * @return elements of the questions
     */
    private By numbers_of_questions(){
        return By.xpath("//div[@class='instances']/div");
    }

    //*** Keywords and Actions ***//

    /**
     * This method is used for clicking on the Work Sheet section
     */
    public void clickOnWorkSheetSection() {
        driver.findElement(work_sheet_section()).click();
    }

    /**
     * This method counting the number of questions inside the worksheet and prints them
     */
    public void printTheNumberOfQuestions(){
        driver.findElements(numbers_of_questions());
        ArrayList<WebElement> list = new ArrayList<>(driver.findElements(numbers_of_questions()));
        int counter = 0;
        for(WebElement we : list){
            counter++;
        }
        System.out.println("=============>>>>>>\n The Number of questions = " + counter + "\n<<<<<<=============");
    }

    /**
     * This method checks if the title is correct or not
     * @param word, which will be inserted to look for a locator contains the same string
     * @return Boolean if the entered word exists on the title or not
     */
    public Boolean theTitleOfThePage(String word){
        return driver.findElement(By.xpath("//title[contains(text(),' " + word + " ')]")).isEnabled();
    }

}
