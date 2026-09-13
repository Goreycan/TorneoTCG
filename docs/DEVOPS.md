# Guía DevOps y Git

## Estrategia de ramificación

Se utiliza **GitFlow simplificado** para separar el desarrollo estable de la integración y permitir cambios controlados.

- `main`: versión estable y entregable.
- `develop`: integración de cambios antes de producción.
- `feature/<nombre>`: nuevas funcionalidades o mejoras.
- `hotfix/<nombre>`: correcciones urgentes sobre una versión estable.

## Convención de commits

Se utiliza Conventional Commits:

- `feat:` nueva funcionalidad.
- `fix:` corrección de errores.
- `docs:` documentación.
- `test:` pruebas.
- `refactor:` reorganización sin cambio funcional.
- `ci:` cambios de automatización.

Ejemplo: `feat: agregar validacion de jugador`.

## Flujo de Pull Request

1. Crear una rama `feature/*` o `hotfix/*` desde la rama correspondiente.
2. Realizar commits pequeños y descriptivos.
3. Hacer `push` al repositorio remoto.
4. Abrir Pull Request hacia `develop` para features o hacia `main` para hotfixes críticos.
5. Revisar cambios y validar GitHub Actions.
6. Hacer merge cuando la revisión y las validaciones sean satisfactorias.

## Control de versiones

No se deben subir credenciales, contraseñas, archivos compilados ni configuraciones sensibles. Los cambios deben quedar trazables mediante commits y Pull Requests.