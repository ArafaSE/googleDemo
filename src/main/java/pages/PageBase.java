package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    protected WebDriver driver; // protected (package scope)
    public JavascriptExecutor jse;
    public Select select;

    // create constructor
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    protected void clickButton(WebElement btn) {
        btn.click();
    }

    protected void setTextElement(WebElement TextElement, String textValue) {
        TextElement.sendKeys(textValue);
    }

    public void clickEnterKey(WebElement enterElement) {
        enterElement.sendKeys(Keys.ENTER);
    }


    protected void waitUntilElementBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilElementNotVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitSec(Integer sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollToBottom(int value){
        String scrTxt = "scrollBy(0," + value + ")";
        jse.executeScript(scrTxt);
    }

}
