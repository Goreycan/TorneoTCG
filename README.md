# Torneo TCG - Magic: The Gathering (Backend)

Sistema distribuido basado en arquitectura de microservicios para la gestión completa de torneos de Magic Commander. Este proyecto permite administrar jugadores, mazos, inscripciones, generación de rondas y registro de resultados.

## Estrategia DevOps - GitFlow

Para esta evaluación se utiliza **GitFlow simplificado**, porque permite mantener una rama estable (`main`), una rama de integración (`develop`) y ramas aisladas para nuevas funcionalidades y correcciones urgentes. Esto facilita la trazabilidad, revisión por Pull Request y control de versiones en un equipo colaborativo.

### Ramas obligatorias

- `main`: código estable y entregable.
- `develop`: integración de funcionalidades antes de pasar a producción.
- `feature/<nombre>`: desarrollo de nuevas funcionalidades.
- `hotfix/<nombre>`: correcciones urgentes que deben llegar a la versión estable.

### Flujo de trabajo

`feature/*` → Pull Request → `develop` → Pull Request → `main`

Para una corrección crítica: `hotfix/*` → Pull Request → `main` y posterior sincronización con `develop`.

## Convenciones de commits

Se adopta Conventional Commits:

- `feat:` nueva funcionalidad.
- `fix:` corrección de errores.
- `docs:` documentación.
- `test:` pruebas.
- `refactor:` refactorización sin cambio funcional.
- `ci:` automatización CI/CD.

Ejemplo: `feat: agregar validacion de jugador`.

## Pull Requests y revisión

Cada cambio debe realizarse en una rama propia y enviarse mediante Pull Request. El autor debe describir el cambio y su propósito. Antes del merge se deben revisar los archivos modificados, verificar las pruebas/compilación automatizada y resolver observaciones.

La evaluación exige simular al menos **2 features y 1 hotfix** mediante Pull Requests.

## GitHub Actions y CI/CD

El repositorio debe ejecutar una acción de integración continua en cada `push` a `develop` y en cada Pull Request dirigido a `main`. La acción valida automáticamente que el código pueda integrarse, reduciendo errores antes del merge.

## Estructura y control de versiones

El proyecto contiene microservicios independientes, API Gateway, Eureka Server, Docker Compose y documentación. No se deben versionar secretos, contraseñas, archivos compilados ni configuraciones sensibles.

## Arquitectura y Microservicios Implementados

El sistema está construido bajo el patrón **CSR (Controller-Service-Repository)** y cuenta con microservicios para jugadores/mazos, torneos/rondas, partidas/resultados e infraestructura, además de API Gateway y Eureka Server.

## Tecnologías

- Java & Spring Boot
- Spring Cloud Netflix Eureka
- Spring Cloud Gateway
- DTOs para comunicación inter-servicios
- HATEOAS
- YAML por perfiles
- Swagger/OpenAPI
- Docker Compose
- JUnit 5 y Mockito

## Ejecución local

### Windows
1. Clona el repositorio.
2. Ejecuta `iniciar-todo.bat`.

### Mac / Linux
1. Otorga permisos: `chmod +x iniciar-todo.sh`.
2. Ejecuta `./iniciar-todo.sh`.

## Docker

```bash
docker compose build --no-cache
docker compose up
docker compose down
```
