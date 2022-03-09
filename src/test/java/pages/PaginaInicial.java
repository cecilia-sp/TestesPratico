package pages;

import dao.Queries;
import driver.Driver;
import org.openqa.selenium.WebDriver;

public class PaginaInicial extends BasePage {
    private WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    private Queries querys = new Queries();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    private String comparationColorDataBase;
    private String product;
    private String nameProduct;
    private BasePage utility = new BasePage();
    Integer count = 0;


    protected void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}



