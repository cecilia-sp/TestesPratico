package pages;

import dao.Queries;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class BasePage {

    WebDriver driver = Driver.getDriver();
    private Queries querys = new Queries();

    protected void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public void clickElement(String clickElement) {
        wait(5);
        driver.findElement(By.xpath(clickElement)).click();
    }

    public String getTextElement(String getTextElement) {
        wait(5);
        String retornGetTextElement = driver.findElement(By.xpath(getTextElement)).getText();
        return retornGetTextElement;
    }

    public String getTextElement(By by) {
        wait(5);
        return driver.findElement(by).getText();
    }

    public String getTextAttribute(String getTextAttribute) {
        String retornGetTextAttribute = driver.findElement(By.xpath(getTextAttribute)).getAttribute("title");
        return retornGetTextAttribute;
    }

    public void validaAssert(String message, String expected, String obtained) {
        assertEquals(message, expected, obtained);
    }

    public void exemplo(By by) {
        driver.findElement(by).click();
    }

    public String returnNameProduct() {
        String nameProduct = "//div[@id='Description']//*[contains(@class,'roboto-regular screen768 ng-binding')]";
        nameProduct = getTextElement(nameProduct);
        return nameProduct;
    }

    public String returnDatabase(String fild) {
        String nameProduct = returnNameProduct();
        String comparationColorDataBase = querys.returnInformationBankMasses(fild, nameProduct);
        return comparationColorDataBase;
    }

}
