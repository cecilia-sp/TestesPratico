package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductsPage;

import static driver.Driver.quitDriver;

public class CenarioUm {

	HomePage homePage = new HomePage();
	ProductsPage productsPage = new ProductsPage();
	CartPage cartPage = new CartPage();
	CheckoutPage checkoutPage = new CheckoutPage();


	@Dado("que acesso o site")
	public void que_acesso_o_site() {
		homePage.pageInitial();
	}

	@Dado("clico na opacao epecial Offer")
	public void clico_na_opacao_epecial_offer() throws InterruptedException {
		homePage.optionEpecialOffer();
	}

	@Dado("clico no botao  See offer")
	public void clico_no_botao_see_offer() {
		homePage.buttonEpecialOffer();
	}

	@Entao("valido as especificacoes do produto")
	public void valido_as_especificacoes_do_produto() {
		productsPage.validaEspecificacoesDoProduto();
	}

	@Dado("altero produto com a cor do banco de dados")
	public void altero_produto_com_a_cor_do_banco_de_dados() {
		productsPage.colorCompared();
	}

	@Dado("clico em Add to cart")
	public void clico_em_add_to_cart() {
		productsPage.addToCart();
	}

	@Entao("valido produto adicionado no carrinho")
	public void valido_aproduto_adicionado_no_carrinho() {
		cartPage.cartItems();
	}

	@Entao("valido cor seleciona no carrinho")
	public void valido_cor_seleciona_no_carrinho() {
		cartPage.clickCart();
		cartPage.validateColorCar();
	}

	@Dado("realizo busca")
	public void realizo_busca() {
		homePage.serchPage();
	}

	@Dado("seleciono o produto do banco de dados")
	public void seleciono_o_produto_do_banco_de_dados() {
		homePage.selectSearchedProduct();
	}

	@Dado("altero produto com cor diferente do banco de dados")
	public void altero_produto_com_cor_diferente_do_banco_de_dados() {
		productsPage.changeProductColor();
	}

	@Dado("altero quantidade de produtos e clico Add to cart")
	public void altero_quantidade_de_produtos_e_clico_add_to_cart() {
		productsPage.changeQuantityProduct();
	}

	@Entao("serei redirecionado para o checkout e valido total da compra")
	public void serei_redirecionado_para_o_checkout_e_valido_total_da_compra() {
		checkoutPage.clickCheckot();
	}

	@Entao("realizo alteracao da cor do produto no banco")
	public void realizo_alteracao_da_cor_do_produto_no_banco() {
		checkoutPage.updateProductColorDatabase();
	}

	@Dado("clico o carrinho")
	public void clico_o_carrinho() {
		productsPage.addToCart();
		cartPage.clickCart();
	}

	@Dado("removo produto")
	public void removo_produto() {
		checkoutPage.removeProduct();
	}

	@Entao("valido carrinho vazio")
	public void valido_carrinho_vazio() {
		checkoutPage.valdateCarEmpty();
	}

	@Dado("fecho site")
	public void fecho_site() {
		quitDriver();
	}

}
