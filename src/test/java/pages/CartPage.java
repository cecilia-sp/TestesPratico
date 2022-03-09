package pages;

import dao.Queries;

public class CartPage extends BasePage {
    private Queries querys = new Queries();

    public void cartItems() {
        String item = quantityItemsCart();
        validaAssert("", "1", item);
    }

    public String quantityItemsCart() {
        String quantityCartItems = "//header//*[@class='cart ng-binding']";
        String returnQuantityItens = getTextElement(quantityCartItems);
        return returnQuantityItens;
    }

    public void clickCart() {
        String cart = "//*[@id='menuCart']";
        clickElement(cart);
    }

    public void validateColorCar() {
        String product = "//label[@class='roboto-regular productName ng-binding']";
        product = getTextElement(product);
        String comparationColorDataBase = querys.returnInformationBankMasses("COLOR", product);
        String compareColor = "//span[@title='" + comparationColorDataBase + "']";
        compareColor = getTextAttribute(compareColor);
        validaAssert("Valida cor do banco com a do carrinho ", comparationColorDataBase, compareColor);
    }

}
