package pages;

import dao.Queries;
import org.openqa.selenium.By;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class CheckoutPage extends BasePage {
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    private Queries querys = new Queries();

    public void clickCheckot() {
        double valueProduct = productsPage.totalValueProduct();
        productsPage.addToCart();
        String checkout = "//header//button[@id='checkOutPopUp']";
        clickElement(checkout);
        String totalSumProduct = String.valueOf(sumTotalValueToCart(valueProduct));
        String totalCart = "//*[@class='roboto-medium totalValue ng-binding']";
        totalCart = getTextElement(totalCart);
        totalCart = (totalCart.replaceAll("\\$", "").replaceAll("\\,", ""));
        validaAssert("Validando total do carrinho", totalCart, totalSumProduct);
    }

    public double sumTotalValueToCart(double valueProduct) {
        String quantityItemsCart = cartPage.quantityItemsCart();
        double convertQuantityItemsCart = Double.parseDouble(quantityItemsCart);
        double somaProduto = valueProduct * convertQuantityItemsCart;
        return somaProduto;
    }

    public void updateProductColorDatabase() {
        String colorProductCheckout = "//*[@id='userCart']//a//label//*[@class='ng-binding']";
        colorProductCheckout = getTextElement(colorProductCheckout);
        String nameProductCheckout = "//div[@id='userCart']//a//h3[@class='ng-binding']";
        nameProductCheckout = getTextElement(nameProductCheckout);
        System.out.println(nameProductCheckout);
        String colorProductDataBase = querys.returnInformationBankMasses("COLOR", nameProductCheckout);
        assertNotEquals("Validando cor do carrinho", colorProductDataBase, colorProductCheckout);
        querys.updateInformation("COLOR", colorProductCheckout, nameProductCheckout);
    }

    public void removeProduct() {
        String removeProduct = "//a[@class='remove red ng-scope']";
        clickElement(removeProduct);

    }

    public void valdateCarEmpty() {
        boolean menssageCarrinhoVazio = driver.findElement(By.xpath(
                "//div[@class='bigEmptyCart center']//label[@translate=\"Your_shopping_cart_is_empty\"]")) != null;
        boolean botaoCarrinhoVazio = driver.findElement(By.xpath("//a[text()='CONTINUE SHOPPING']")) != null;
        assertNotNull(menssageCarrinhoVazio);
        assertNotNull(botaoCarrinhoVazio);
        if (menssageCarrinhoVazio == true && botaoCarrinhoVazio == true) {
            System.out.println("Carrinho vazio!");
        }
    }
}
