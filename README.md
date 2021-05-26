# Avaliação Java + React

## Descrição

O projeto foi dividido em duas partes : front-end e back-end. 
O Front-end foi implementado em react como solicitado e back-end
foi implementado com o framework SpringBoot . Utilizei outro 
banco de memória (h2), devido a facilidade de uso . Não foi possível
implementar todas as funcionalidades a tempo, mas é possível observar
o fluxo básico solicitado. 

### Rest
A API foi baseada no estilo de arquitetura REST, embora não tenha
seguido a risca todos os pricípios Restfull.

## Como Realizar o build 

mvn clean install -DskipTests=true

## EndPoints 

### Realização de checkout de informações de cartão de usuário :
`http://localhost:8081/gamestore/checkout`
#### Método :Post

#### Exemplo de body 

{
"name":"Vagner da Silva",
"cpf":"09591525710",
"endereco":"Rua Manoel Ivo 223, Raul Veiga, São Gonçalo RJ",

    "creditCard": {
            "cardNumber":"0000000000000000",
            "expirationMonth":10,
            "expirationYaer":2021,
            "cvv":123,
            "flag":"MASTER",
            "cardHolder":"Vagner Santos da Silva"
    }
}

#### Exemplo de header 
`user_id  :1`

### Criar  carrinho de compras

`localhost:8081/gamestore/cart/`

#### Exemplo de header
`user_id  :1`
`sorted_by:"name"`
`ascending:true`

### Adicionar produto ao carrinho de compras

#### Método :Post

`localhost:8081/gamestore/cart/product/3`

#### Exemplo de header
`user_id  :1`

### Remover produto de carrinho de compras 
#### Método :Delete
`localhost:8081/gamestore/cart/product/3`

#### Exemplo de header
`user_id  :1`

### Carregar lista de produtos de carrinho de compras
#### Método :Get
`localhost:8081/gamestore/cart`

#### Exemplo de header
`user_id  :1`
`sorted_by:"name"`
`ascending:true`

### Carregar lista de jogos 
### Método : Get
`localhost:8081/gamestore/games`


### Carregar informações de jogo específico
### Método : Get
`localhost:8081/gamestore/games/1`

####Exemplo  de header 
`sorted_by : name`


### Carregar uma imagem de um jogo específico
### Método :Get
`http://localhost:80801/gamestore/product/image/name-game.png`

