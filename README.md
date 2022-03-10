# Testes Práticos 

## Descrição


- Teste 1: Teste de unidade na pasta main que valida recarga onde será descontado da conta.
- Teste 2: API correios via postman.
  - Download Postman: https://www.postman.com/downloads/ 
  - Endpoint : https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente 
  - WSDL (Capturar o body do serviço): https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl - (Utilize a operação de "consultaCEP")
- Testes 3: Validaçãões no site.

### Ferramentas e linguagens utilizadas
 - [x] Java
 - [x] Cucumber
 - [x] Junit
 - [x] Seleniun
 - [x] MySql
 - [x] Maven

### Requisitos
- [x] Maven instalado
- [x] Mysqul instalado
- [x] Postman instalado
- [x] JDK instalado

### Features
##### Cenários de Teste

  - [x] Cenário 1 – Validar especificações do produto
    - Acessar o site https://advantageonlineshopping.com 
    - No menu, clicar na opção “Special Offer” o Clicar no botão "See offer"
    - Alterar a cor do produto de acordo com a cor informada no banco de automação o Clicar no botão "Add to cart" 
    - Validar que produto foi adicionado ao carrinho com a cor selecionada

  - [x] Cenário 2 – Validar alteração de cor do produto no carrinho
    - Acessar o site https://advantageonlineshopping.com o No menu, clicar na opção "Special Offer"
    - Clicar no botão “See offer” o Alterar a cor do produto de acordo com a cor informada no banco
    - Clicar no botão “Add to cart” 
    - Validar que produto foi adicionado ao carrinho com a cor selecionada

  - [x] Cenário 3 – Validar página de checkout
    - Acessar o site https://advantageonlineshopping.com 
    - Pesquisar o produto clicando no ícone de lupa  seguir o nome do produto de acordo com banco de dados
    - Selecionar produto pesquisado 
    - Alterar a cor do produto para uma diferente da existente no banco de automação 
    - Alterar a quantidade de produtos que deseja comprar o Clicar no botão “Add to cart” o 
    - Acessar a página de checkout 
    - Validar que a soma dos preços corresponde ao total apresentado na página de checkout
    - Realizar um update no banco de automação alterar a cor existente no banco para a cor selecionada no teste

  - [x] Cenário 4 – Remover produto do carrinho de compras
    - o Acessar o site https://advantageonlineshopping.com 
    - No menu, clicar na opção “Special Offer” o Clicar no botão “See offer” 
    - Clicar no botão “Add to cart” 
    - Clicar no carrinho de compras 
    - Remover produto do carrinho de compras o Validar que o carrinho de compras está vazio



##Informações

### Teste 1:
- Para testar é necessário rodar a class TesteRecarga
  - Caminho: src\main\java

### Teste 2:  
- Será necessário intalar o postman e importar a collection Correios.postman_collection
  - Caminho: api/api_postman

### Teste 3:
- Para criar o banco de dados rodar os metodos da class CreateDataBase do package dao 
- Caminho: src\test\java\dao
- Para executar as features precisa colocar o nome do teste na na class Runner do package runner
  - Caminho: src\test\java\runner



  