package pages;

import driver.Driver;
import maps.ProductsMaps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNotEquals;

public class ProductsPage extends BasePage {
    private WebDriver driver = Driver.getDriver();
    ProductsMaps productsMaps = new ProductsMaps();
    Integer count = 0;

    public void validaEspecificacoesDoProduto() {
        wait(5);
        for (int i = 1; i <= 9; i++) {
            boolean eleSelected= driver.findElement(productsMaps.fild(i)).isDisplayed();
            if (eleSelected == true){
                String field =  getTextElement(productsMaps.fild(i));
                String description =  getTextElement(productsMaps.description(i));
                field = field.replaceAll("\\s+", "_");
                String comparator = returnDatabase(field);
                validaAssert("Valida campo " + field, comparator, description);
            }
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
