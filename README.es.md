[English](README.md) | [Português](README.pt.md)

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![H2](https://img.shields.io/badge/H2-0078D4?style=for-the-badge&logo=h2&logoColor=white)](https://www.h2database.com/)
[![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white)](https://swagger.io/)

# Servicio de Precios de Comercio Electrónico con Spring Boot
## 📝 Descripción
Este proyecto es una API Rest utilizando Spring Boot que tiene como objetivo devolver los precios aplicables de productos en base a parámetros como ID del producto, ID de la marca y fecha de aplicación.

## ⚙️ Tecnologías
- Java 17
- Spring Boot
- Maven
- H2 Database

## ✅ Requisitos Previos

### Postman
Para probar los Endpoints, importe la Colección y los Entornos JSON para Postman que se encuentran en los siguientes directorios:
- `src/main/resources/docs/collections/ecommerce-price-service.postman_collection.json`.

## 📦 Instalación
### 1. Clonar el repositorio

```bash
  git clone https://github.com/joseppamancio/ecommerce-price-service.git
```

### 2. Importar el proyecto en su IDE


### 3. Ejecutar el proyecto
Al ejecutar el proyecto, la aplicación se iniciará y estará lista para su uso.

### 4. Probar los Endpoints
Con la colección y el entorno importados en Postman, podrá probar los Endpoints de la API. 
Se han puesto a disposición los Endpoints:

##### Endpoint para verificar si la aplicación está en funcionamiento
- **GET http://localhost:8080/ecommerce-price-service/ping**

#### Endpoint para buscar los precios aplicables
- **GET http://localhost:8080/ecommerce-price-service/api/prices?productId=35455&brandId=1&applicationDate=2020-06-15-10:00:00**

Utilice las credenciales:

- **Username: admin**
- **Password: notset**

**NOTA:** Las credenciales pueden ser modificadas mediante las variables de entorno API_USER_NAME y API_USER_PASSWORD que, si no están definidas, asumirán los valores predeterminados.


Finalmente, este endpoint de nuestra API devolverá una lista de precios aplicables para el producto, marca y fecha indicados.


### 5. Accediendo a H2 Database
Para acceder a H2, acceda a la URL http://localhost:8080/ecommerce-price-service/h2-console y utilice las siguientes credenciales:

- **Username: sa**
- **Password: password**

**NOTA:** Las credenciales pueden ser modificadas mediante las variables de entorno DB_USERNAME y DB_PASSWORD que, si no están definidas, asumirán los valores predeterminados.

Tendrá acceso a la base de datos ecommerce a través de la interfaz gráfica de H2.

## 📚 Documentación
La documentación de la API se realizó utilizando Swagger y se puede acceder a través de la URL http://localhost:8080/ecommerce-price-service/swagger-ui.html.

La carpeta resources contiene:  
- collections: contiene la colección y el entorno de Postman.
- api.yml: contiene la documentación de la API en formato YAML.
- documentation: contiene la documentación de la API en formato EMR y UML.
- db: contiene el script de creación e inserción de datos en la base de datos H2.

# 🎥 Video de Demostración
https://github.com/user-attachments/assets/9940d92b-0e0b-4b3e-8821-d8e68003f935
