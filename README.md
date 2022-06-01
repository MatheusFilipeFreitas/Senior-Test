# Senior-Test API

## Getting Started 

 - Overview
 - Technologies used
 - Installing
 - Entities
 - Returns
 
 ## Overview
 
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

 
 ## Technologies used
 
- PostgreSQL Database
- Java 8+
- Maven
- Spring
- JPA
- REST with JSON

## Installing

The project was created and tested using [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/) (Build #IU-212.5284.40, built on September 14, 2022).
The database used was created using Postgree [pgAdmin4](https://www.postgresql.org/download/) (Build 6.4).
For testing the application is necessary to download [Postman](https://www.postman.com/) (used version: Build 9.19.3)

### Entities

| Entity | METHOD |
| ------ | ------ |
| Client | `GET`, `POST`, `PUT`, `DELETE` |
| Product | `GET`, `POST`, `PUT`, `DELETE` |
| Order Inventory | `GET`, `POST`, `PUT`, `DELETE` |
| Order | `GET`, `POST`, `PUT`, `DELETE` |


## Returns

### Client
#### OBS: For testing you can take the url just by pressing the right button above the hyperlink and pressing "copy url link" (Search for -url:)
 - URL: [/client](https://localhost:8080/client)
    - **List All Method**
      - `get`
      - url: [/client/all](https://localhost:8080/client/all)
      return: Object object (JSON Response)
      ```sh
       [
        {
         "id": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
         "name": "Emilly"
        }
       ]
      ```
     - **Insert Method**
       - `post`
       - url: [/client/add](https://localhost:8080/client/add)
       input: JSON
       ```sh
        {
          "name": "Emilly"
        }
       ```
       return: Object object (JSON Response)
     ```sh
      {
         "id": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
         "name": "Emilly"
       }
     ```
       
     - **Update Method**
       - `put`
       - url: [/client/update/{id}](https://localhost:8080/client/update/{id}) (where {id}, put your `client id`)
       input: JSON
       ```sh
        {
          "name": "Emilly"
        }
       ```
     
       return: Object object (JSON Response)
       
       ```sh
       {
          "id": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
          "name": "Emilly"
       }
       ```
      - **Delete Method**
        - `delete`
        - url: [/client/delete/{id}](https://localhost:8080/client/delete/{id}) (where {id}, put your `client id`)

  return: void (JSON Response)
       
 ### Product
 - URL: [/product](https://localhost:8080/product)
    - **List All Method**
      - `get`
      - url: [/product/all](https://localhost:8080/product/all)
      return: Object object (JSON Response)
      ```sh
      [
        {
          "id": "f3cbef22-107e-4d13-86b1-44af45c04023",
          "name": "Microsolda",
          "description": "Lab",
          "value": 1830.1,
          "type": "s"
        }
      ]
      ```
     - **Insert Method**
       - `post`
       - url: [/product/add](https://localhost:8080/product/add)
       input: JSON
       ```sh
        {
           "name": "iPhone 12",
           "description": "Lançamento: 2020",
           "value": 6390.90,
           "type": "p"
         }
       ```
       return: Object object (JSON Response)
     ```sh
       {
         "id": "969240d8-f2fa-4ba0-99c6-e7d243a5ef39",
         "name": "iPhone 12",
         "description": "Lançamento: 2020",
         "value": 6390.9,
         "type": "p"
       }
     ```
       
     - **Update Method**
       - `put`
       - url: [/product/update/{id}](https://localhost:8080/product/update/{id}) (where {id}, put your `product id`)
       input: JSON
       ```sh
         {
           "name": "iPhone 12",
           "description": "Lançamento: 2020",
           "value": 6390.90,
           "type": "p"
         }
       ```
     
       return: Object object (JSON Response)
       
       ```sh
         {
           "id": "969240d8-f2fa-4ba0-99c6-e7d243a5ef39",
           "name": "iPhone 12",
           "description": "Lançamento: 2020",
           "value": 6390.9,
           "type": "p"
         }
       ```
     
      - **Delete Method**
        - `delete`
        - url: [/product/delete/{id}](https://localhost:8080/product/delete/{id}) (where {id}, put your `product id`)

  return: void (JSON Response)
       
 
 ### Order Inventory
 - URL: [/inventory](https://localhost:8080/inventory)
    - **List All Method**
      - `get`
      - url: [/inventory/all](https://localhost:8080/inventory/all)
      return: Object object (JSON Response)
      #### OBS: In this case `"product":{}` is the product entity! 
      ```sh
      [
         {
           "id": "361ad155-7362-4b27-8eb2-13c44433a2c2",
           "quantity": 100,
           "value": 1035090.0,
           "product": {
             "id": "146ce2f2-3af9-48af-a31b-dde0bc5b0ac4",
             "name": "iPhone 13 PRO Max",
             "description": "Lançamento: 2021",
             "value": 10350.9,
             "type": "p"
            }
         }
      ]
      ```
     - **Insert Method**
       - `post`
       - url: [/inventory/add](https://localhost:8080/inventory/add)
       input: JSON
       #### OBS: The `"value":` is calculated automatically, so there is no need to send this atribute into your JSON.
       ```sh
         {
             "quantity": 5,
             "productID": "f3cbef22-107e-4d13-86b1-44af45c04023"
          }
       ```
       return: Object object (JSON Response)
       #### OBS: In this case `"product":{}` is the product entity! 
     ```sh
        {
           "id": "77e914a4-db7f-4f26-bdb4-ed05c65c4168",
           "quantity": 5,
           "value": 9150.5,
           "product": {
              "id": "f3cbef22-107e-4d13-86b1-44af45c04023",
              "name": "Microsolda",
              "description": "Lab",
              "value": 1830.1,
              "type": "s"
            }
        }
     ```
       
     - **Update Method**
       - `put`
       - url: [/inventory/update/{id}](https://localhost:8080/product/inventory/{id}) (where {id}, put your `inventory id`)
       input: JSON
       #### OBS: The `"value":` is calculated automatically, so there is no need to send this atribute into your JSON.
       ```sh
         {
             "quantity": 5,
             "productID": "f3cbef22-107e-4d13-86b1-44af45c04023"
          }
       ```
       return: Object object (JSON Response)
       #### OBS: In this case `"product":{}` is the product entity! 
     ```sh
        {
           "id": "77e914a4-db7f-4f26-bdb4-ed05c65c4168",
           "quantity": 5,
           "value": 9150.5,
           "product": {
              "id": "f3cbef22-107e-4d13-86b1-44af45c04023",
              "name": "Microsolda",
              "description": "Lab",
              "value": 1830.1,
              "type": "s"
            }
        }
     ```
     
      - **Delete Method**
        - `delete`
        - url: [/inventory/delete/{id}](https://localhost:8080/inventory/delete/{id}) (where {id}, put your `inventory id`)

  return: void (JSON Response)
     
     
  ### Order
 - URL: [/Order](https://localhost:8080/order)
    - **List All Method**
      - `get`
      - url: [/order/all](https://localhost:8080/order/all)
      return: Object object (JSON Response)
      #### OBS: In this case `"client":{}` is the client entity, `"orderInventory":{}` is the order inventory entity, `"product":{}` is the product entity! 
      ```sh
       [
         {
            "id": "e7a908a3-867a-4696-b256-13d7e06cc28f",
            "date": "2022-04-22",
            "term": "2022-05-23",
            "status": "c",
            "quantity": 5,
            "value": 9150.5,
            "discount": 0.0,
            "client": {
                "id": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
                "name": "Emilly"
            },
            "orderInventory": {
            "id": "d99780a1-076b-478a-ba03-6e2ea8e8c3c8",
            "quantity": 5,
            "value": 9150.5,
            "product": {
                "id": "f3cbef22-107e-4d13-86b1-44af45c04023",
                "name": "Microsolda",
                "description": "Lab",
                "value": 1830.1,
                "type": "s"
            }
         }
      ]
      ```
     - **Insert Method**
       - `post`
       - url: [/order/add](https://localhost:8080/order/add)
       input: JSON
       #### OBS: The `"value":` and `"quantity"` is calculated automatically, so there is no need to send these atributes into your JSON.
       ```sh
        {
           "date": "2022-05-22",
           "status": "o",
           "term": "2022-08-31",
           "clientID": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
           "discount": 10,
           "orderInventoryID": "d99780a1-076b-478a-ba03-6e2ea8e8c3c8"
        }
       ```
       return: Object object (JSON Response)
       #### OBS: In this case `"client":{}` is the client entity, `"orderInventory":{}` is the order inventory entity, `"product":{}` is the product entity! 
     ```sh
        {
            "id": "b1872c48-9dff-4914-a97b-29f4e911866f",
            "date": "2022-04-22",
            "term": "2022-05-23",
            "status": "o",
            "quantity": 5,
            "value": 9150.5,
            "discount": 10.0,
            "client": {
                "id": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
                "name": "Emilly"
            },
            "orderInventory": {
            "id": "d99780a1-076b-478a-ba03-6e2ea8e8c3c8",
            "quantity": 5,
            "value": 9150.5,
            "product": {
                "id": "f3cbef22-107e-4d13-86b1-44af45c04023",
                "name": "Microsolda",
                "description": "Lab",
                "value": 1830.1,
                "type": "s"
            }
         }
     ```
       
     - **Update Method**
       - `put`
       - url: [/order/update/{id}](https://localhost:8080/order/inventory/{id}) (where {id}, put your `order id`)
       input: JSON
       #### OBS: The `"value":` and `"quantity"` is calculated automatically, so there is no need to send these atributes into your JSON.
       ```sh
        {
           "date": "2022-05-22",
           "status": "o",
           "term": "2022-08-31",
           "clientID": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
           "discount": 10,
           "orderInventoryID": "d99780a1-076b-478a-ba03-6e2ea8e8c3c8"
        }
       ```
       return: Object object (JSON Response)
       #### OBS: In this case `"client":{}` is the client entity, `"orderInventory":{}` is the order inventory entity, `"product":{}` is the product entity! 
       
     ```sh
        {
            "id": "b1872c48-9dff-4914-a97b-29f4e911866f",
            "date": "2022-04-22",
            "term": "2022-05-23",
            "status": "o",
            "quantity": 5,
            "value": 9150.5,
            "discount": 10.0,
            "client": {
                "id": "a199e03b-36f2-4acd-8a3c-62b90a3688fd",
                "name": "Emilly"
            },
            "orderInventory": {
            "id": "d99780a1-076b-478a-ba03-6e2ea8e8c3c8",
            "quantity": 5,
            "value": 9150.5,
            "product": {
                "id": "f3cbef22-107e-4d13-86b1-44af45c04023",
                "name": "Microsolda",
                "description": "Lab",
                "value": 1830.1,
                "type": "s"
            }
         }
     ```
     
      - **Delete Method**
        - `delete`
        - url: [/order/delete/{id}](https://localhost:8080/order/delete/{id}) (where {id}, put your `order id`)

  return: void (JSON Response)
     

