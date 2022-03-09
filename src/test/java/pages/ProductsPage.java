package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNotEquals;

public class ProductsPage extends BasePage {
    private WebDriver driver = Driver.getDriver();
    CartPage cartPage = new CartPage();
    Integer count = 0;

    public void validaEspecificacoesDoProduto() {
        wait(5);
        for (int i = 1; i <= 9; i++) {
            String field = driver
                    .findElement(By.xpath("//div[@class=\"roboto-light list ng-scope\"][" + i + "]//label[1]"))
                    .getText();
            String description = driver
                    .findElement(By.xpath("//div[@class=\"roboto-light list ng-scope\"][" + i + "]//label[2]"))
                    .getText();
            field = field.replaceAll("\\s+", "_");
            String comparation = returnDatabase(field);
            validaAssert("Valida campo " + field, comparation, description);
        }
    }

    public String selectedColor() {
        wait(3);
        String searchSelectedColor = "//span[@id='bunny'][contains(@class,'colorSelected')]";
        String returnsearchSelectedColor = getTextAttribute(searchSelectedColor);
        return returnsearchSelectedColor;
    }

    public void changeProductColor() {
        String colorSelect = selectedColor();
        String colorBanco = returnDatabase("COLOR");
        ArrayList<String> list = new ArrayList<String>(
                Arrays.asList("BLUE", "BLACK", "GRAY", "PURPLE", "RED", "YELLOW"));
        for (int i = 0; i < list.size(); i++) {
            String listColor = list.get(i);
            if (colorSelect.equals(colorBanco)) {
                driver.findElement(By.xpath("//span[@id='bunny'][contains(@title,'" + listColor + "')]")).click();
                colorSelect = selectedColor();
            }
        }
        assertNotEquals(colorBanco, colorSelect);
    }

    public void colorCompared() {
        String returnSearchColor = selectedColor();
        String comparationColorDataBase = returnDatabase("COLOR");
        if (!returnSearchColor.equals(comparationColorDataBase)) {
            String returnSearchColorcompared = "//span[@id='bunny'][contains(@title,'" + comparationColorDataBase + "')]";
            clickElement(returnSearchColorcompared);
            returnSearchColor = selectedColor();
            validaAssert("Cor do banco igual a selecionada no site", comparationColorDataBase, returnSearchColor);
        }
    }

    public void addToCart() {
        String addToCart = "//button[@name='save_to_cart']";
        clickElement(addToCart);
    }

    public void changeQuantityProduct() {
        count = 0;
        while (count < 2) {
            clickMoreProducts();
            count++;
        }
        addToCart();
    }

    public void clickMoreProducts() {
        String addProducts = "//div[@class='e-sec-plus-minus']//div[3]";
        clickElement(addProducts);
    }

    public double totalValueProduct() {
        String value = productValue();
        value = value.replaceAll("\\$", "");
        double convertedValue = Double.parseDouble(value);
        return convertedValue;
    }

    public String productValue() {
        String productValue = "//div[@id='Description']/h2[@class='roboto-thin screen768 ng-binding']";
        productValue = getTextElement(productValue);
        return productValue;
    }


}
