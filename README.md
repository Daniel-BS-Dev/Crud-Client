# CRUD Client
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Daniel-BS-Dev/bootcamp-devsuperior/blob/main/LICENSE)

# Sobre o projeto

CRUD Client é um aplicação backend construida durante a parte 1 do **Bootcamp DevSuperior 2.0**, curso organizado pela [DevSuperior]
(https:devsuperior.com "Site da devSuperior").

A aplicação consiste em um CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capitulo:

   * Busca paginada de recursos
   * Busca de recurso por Id
   * Inserir novo recurso
   * Atualizar recurso
   * Deletar recurso
   
# Modelo Conceitual
![ima (2)](https://user-images.githubusercontent.com/81425846/113962228-a246c880-97fd-11eb-8224-3605e7a1de6d.png)

# Tecnologias Utilizadas
   - Java
   - Spring Boot
   - JPA / Hibernate
   - Maven
   
# Como executar o projeto

Pré-requisitos : Java 11

* Importação do projeto

     Fazer um simples clone do projeto no Github, e importar e executar no STS

* Testes manuais no Postman, você deverá ter as requisições Postman abaixo:
    
 ```java
   # Busca paginada de clientes
     GET 
         /clients?page=0&linesPerPage=12&direction=ASC&orderby=name
    
   # Busca de cliente por Id
     GET 
        /clients/1
     
   # Inserção de novo cliente
     POST 
        /clients
       {
           "name": "Maria Silva",
           "cpf": "12345678901",
           "income": 6500.0,
           "birthDate":"1994-07-20T10:30:00Z",
           "children": 2
      }
     
    # Atualização de cliente
     PUT 
         /clients/1
      {
             "name" : "Maria Silva",
             "cpf": "12345678901",
             "income": 6500.0,
             "birthDate" : "1994-07-20T10:30:00Z",
             "children": 2
      }
      
     # Deleção de cliente
       DELETE
         /clients/1
  ``````````
  


# Autor 

Daniel Benedito da Silva

Email: danielbenedito263@gmail.com












































