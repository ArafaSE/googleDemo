package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends PageBase {
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'Ww4FFb')]")
    List<WebElement> searchResultsElementsList;

    @FindBy(xpath = "//div[contains(@class, 'v5yQqb')]")
    List<WebElement> resultsAdsElementsList;

    @FindBy(xpath = "//div[contains(@class, 'CCgQ5')]/span/span")
    List<WebElement> resultsAdsTitlesElementsList;


    public List<WebElement> getSearchResultsList() {
        return searchResultsElementsList;
    }

    public  List<WebElement> getResultsAdsElementsList(){
        return resultsAdsElementsList;
    }

    public boolean isAllAdsResultsTitlesDisplayed(){
        for ( WebElement element : resultsAdsTitlesElementsList) {
            if (!element.isDisplayed()) return false;
        }
        return true;
    }
}
