# API Gateway

Este módulo expone un punto de entrada HTTP para las APIs y enruta peticiones hacia los servicios backend.

## Requisitos

- Java 21
- Maven

## Ejecución

Desde la raíz del módulo:

```bash
mvn spring-boot:run
```

El gateway escuchará en:

```text
http://localhost:8081
```

## Rutas

- `http://localhost:8081/api/torneo/**` se enruta hacia `http://localhost:8080`

## Pruebas

Ejecuta las pruebas con:

```bash
mvn test
```
