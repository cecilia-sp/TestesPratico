#language:pt
Funcionalidade: Validar site https://advantageonlineshopping.com

	@ValidaEspecificacaoes
	Cenario: Validar especificacoes do produto
		Dado que acesso o site
		E clico na opacao epecial Offer
		E clico no botao  See offer
		Entao valido as especificacoes do produto
		E fecho site


	@ValidarCorAlterada
	Cenario: Validar alteracao de cor do produto no carrinho
		Dado que acesso o site
		E clico na opacao epecial Offer
		E clico no botao  See offer
		E altero produto com a cor do banco de dados
		E clico em Add to cart
		Entao valido produto adicionado no carrinho
		E valido cor seleciona no carrinho
		E fecho site

	@ValidarPaginaCheckout
	Cenario: Validar pagina de checkout
		Dado que acesso o site
		E realizo busca
		E seleciono o produto do banco de dados
		E altero produto com cor diferente do banco de dados
		E altero quantidade de produtos e clico Add to cart
		Entao serei redirecionado para o checkout e valido total da compra
		E realizo alteracao da cor do produto no banco
		E fecho site

	@ValidarCarrinhoVazio
	Cenario: Remover produto do carrinho de compras
		Dado que acesso o site
		E clico na opacao epecial Offer
		E clico no botao  See offer
		E clico em Add to cart
		E clico o carrinho
		E removo produto
		Entao valido carrinho vazio
		E fecho site
