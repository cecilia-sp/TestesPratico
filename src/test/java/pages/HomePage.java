package pages;

import dao.Queries;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver = Driver.getDriver();
    private Queries querys = new Queries();
    Integer count = 0;


    public void pageInitial() {
        driver.get("https://advantageonlineshopping.com");//Correta
        wait(5);
    }

    public void optionEpecialOffer() {
        String epecialOffer = "//a[text()='SPECIAL OFFER']";
        String textEpecialOffer = "//h3[text()='SPECIAL OFFER']";
        String text = "SPECIAL OFFER";
        clickElement(epecialOffer);
        String test = getTextElement(textEpecialOffer);
        validaAssert("Valida click especial offer", text, test);
    }

    public void buttonEpecialOffer() {
        String epecialOffer = "//button[@id='see_offer_btn']";
        clickElement(epecialOffer);
        ;
    }

    public void serchPage() {
        String product = querys.returnProdutdBankMasses();
        System.out.println(product);
        String serchPage = "//*[@id='searchSection']";
        String closeSerchPage = "//*[@class='autoCompleteCover']//img";
        clickElement(serchPage);
        driver.findElement(By.xpath("//*[@id='autoComplete']")).sendKeys(product);
        wait(3);
        driver.findElement(By.xpath("//*[@id='autoComplete']")).sendKeys(Keys.ENTER);
        clickElement(closeSerchPage);
    }

    public void selectSearchedProduct() {
        String product = querys.returnProdutdBankMasses();
        String productName = "//div[@class='cell categoryRight']//li[1]//a[@class='productName ng-binding']";
        String getTextProductName = getTextElement(productName);
        getTextProductName = getTextProductName.toUpperCase();

        while (getTextProductName == product && count < 10) {
            productName = "//div[@class='cell categoryRight']//li[" + count + "]//a[@class='productName ng-binding']";
            getTextProductName = getTextElement(productName);
            getTextProductName = getTextProductName.toUpperCase();
            count++;
        }
        validaAssert("Valida produto buscado tem na pagina", product, getTextProductName);
        clickElement(productName);
    }


}
