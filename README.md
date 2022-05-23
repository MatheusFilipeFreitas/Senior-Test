# Senior-Test API

## Getting Started 

 - Overview
 - Technologies used
 - Installing
 - Entities
 - Returns
 
 ### Overview
 
This API is used for creating simple clients, simple orders, simple products, simple orders inventory.
The code above is only for study purpose.

** RESUME: **

- Deverá ser desenvolvido um cadastro (Create/Read/Update/Delete/List) para as seguintes
entidades: produto/serviço, pedido e itens de pedido.
- Todos as entidades deverão ter um ID único do tipo UUID.
- No cadastro de produto/serviço deverá ter uma indicação para diferenciar um produto de
um serviço.
- Deverá ser possível aplicar um percentual de desconto no pedido, porém apenas para os
itens que sejam produto (não serviço); o desconto será sobre o valor total dos produtos.

 
 ### Technologies used
 
- PostgreSQL Database
- Java 8+
- Maven
- Spring
- JPA
- REST with JSON

### Installing

The project was created and tested using [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/) (Build #IU-212.5284.40, built on September 14, 2022).
The database used was created using Postgree [pgAdmin4](https://www.postgresql.org/download/) (Build 6.4).
For testing the application is necessary to download [Postman](https://www.postman.com/) (used version: Build 9.19.3)

### Entities

- Client: `get`,`post`,`put`,`delete`;
- Product: `get`,`post`,`put`,`delete`;
- Order Inventory: `get`,`post`,`put`,`delete`;
- Order: `get`,`post`,`put`,`delete`;


### Returns

#### Client
 - URL: [/client](https://localhost:8080/client)
    - **List All Method**
     - `get`
     - url: [/client/all](https://localhost:8080/client/all)
     - return: Object object (JSON Response)
     ```
     {
        "id": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
        "name": "Emilly"
    }
     ```
     - **Insert Method**
     - `post`
     - url: [/client/add](https://localhost:8080/client/add)
     - input: JSON
     ```
      {
        "name": "Emilly"
      }
     ```
     - return: Object object (JSON Response)
     ```
     {
        "id": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
        "name": "Emilly"
     }
     ```
     - **Update Method**
     - `put`
     - url: [/client/update/{id}](https://localhost:8080/client/update/{id}) (where {id}, put your `client id`)
     - input: JSON
     ```
      {
        "name": "Emilly"
      }
     ```
     - return: Object object (JSON Response)
     ```
     {
        "id": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
        "name": "Emilly"
     }
     ```
      - **Update Method**
     - `put`
     - url: [/client/update/{id}](https://localhost:8080/client/update/{id}) (where {id}, put your `client id`)
     - input: JSON
     ```
      {
        "name": "Emilly"
      }
     ```
     - return: Object object (JSON Response)
     ```
     {
        "id": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
        "name": "Emilly"
     }
     ```
