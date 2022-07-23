package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    /*
    Web Elements
 */

    @FindBy(name = "q")
    WebElement searchInput;

    public void searchFor(String searchKeyword){
        setTextElement(searchInput, searchKeyword);
        clickEnterKey(searchInput);
    }

}
