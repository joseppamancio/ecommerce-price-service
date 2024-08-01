[English](README.md) | [Español](README.es.md)

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![H2](https://img.shields.io/badge/H2-0078D4?style=for-the-badge&logo=h2&logoColor=white)](https://www.h2database.com/)
[![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white)](https://swagger.io/)

# Ecommerce Price Service com Spring Boot
## 📝 Descrição
Este projeto é uma API Rest utilizando Spring Boot que tem como objetivo retornar os preços aplicáveis de produtos com base em parâmetros como ID do produto, ID da marca e data de aplicação.

## ⚙️ Tecnologias
- Java 17
- Spring Boot
- Maven
- H2 Database

## ✅ Pré-requisitos

### Postman
Para testar os Endpoints, importe a Collection e as Environments JSON para o Postman que se encontra nos seguintes diretórios:
- 'src/main/resources/docs/collections/ecommerce-price-service.postman_collection.json'.

## 📦 Instalação
### 1. Clone o repositório

```bash
  git clone https://github.com/joseppamancio/ecommerce-price-service.git
```

### 2. Importe o projeto em sua IDE


### 3. Execute o projeto
Ao executar o projeto, a aplicação será iniciada e estará pronta para uso.

### 4. Testando os Endpoints 
Com a collection e o environment importados no Postman, você poderá testar os Endpoints da API. 
Foram disponibilizados os Endpoints:

##### Endpoint para verificar se a aplicação está no ar
- **GET http://localhost:8080/ecommerce-price-service/ping**

#### Endpoint para buscar os preços aplicáveis
- **GET http://localhost:8080/ecommerce-price-service/api/prices?productId=35455&brandId=1&applicationDate=2020-06-15-10:00:00**

Utilize as credenciais:

- **Username: admin**
- **Password: notset**

**OBS.:** As credenciais podem ser alteradas por meio das variáveis de ambiente API_USER_NAME e API_USER_PASSWORD que se não estiverem definidas, assumirão os valores padrão.


Por fim, este endpoint da nossa API irá retornar uma lista de preços aplicáveis para o produto, marca e data informados.

### 5. Acessando o H2
   Para acessar o H2, acesse a URL http://localhost:8080/ecommerce-price-service/h2-console e utilize as seguintes credenciais:

- **Username: sa**
- **Password: password**

**OBS.:** As credenciais podem ser alteradas por meio das variáveis de ambiente DB_USERNAME e DB_PASSWORD que se não estiverem definidas, assumirão os valores padrão.

Você terá acesso ao banco de dados ecommerce através da interface gráfica do H2.

## 📚 Documentação
A documentação da API foi feita utilizando o Swagger, e pode ser acessada através da URL http://localhost:8080/ecommerce-price-service/swagger-ui.html.

A pasta resources contém:
- collections: contém a collection e o environment do Postman.
- api.yml: contém a documentação da API em formato YAML.
- documantation: contém a documentação da API em formato EMR e UML.
- db: contém o script de criação e inserção de dados na base de dados H2.

# 🎥 Vídeo de demonstração
https://github.com/user-attachments/assets/9940d92b-0e0b-4b3e-8821-d8e68003f935
