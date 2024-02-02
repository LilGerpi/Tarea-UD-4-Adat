
# Aplicación de Gestión de Inventario

Aplicación web para la gestión de inventario desarrollada con Spring Boot para el backend, MySQL como sistema de gestión de base de datos, y HTML & CSS para el frontend.

## Características

- Operaciones CRUD para productos (Crear, Leer, Actualizar, Eliminar).
- Interfaz de usuario sencilla y funcional para interactuar con la base de datos.
- API Rest para la comunicación entre el frontend y el backend.

## Tecnologías Utilizadas

- Backend: Spring Boot
- Base de datos: MySQL
- Frontend: HTML, CSS
- Pruebas de API: Postman

## Requisitos Previos

Para ejecutar esta aplicación necesitas tener instalado:

- JDK 11 o superior
- Maven
- MySQL Server
- Node.js y npm (opcional, solo si necesitas ejecutar herramientas de frontend)

## Configuración

### Base de Datos

1. Crea una base de datos en MySQL llamada `tienda`.
2. Ejecuta el script SQL proporcionado en `/src/main/resources/db/migration` para crear la tabla `productos`.

### Backend

1. Actualiza el archivo `src/main/resources/application.properties` con tus credenciales de MySQL.
2. Desde la raíz del proyecto, ejecuta:

```bash
mvn spring-boot:run`` 
```
### Frontend

1.  Navega al directorio `frontend` desde la terminal.
2.  Si tienes un servidor HTTP local (como `http-server` de npm), ejecútalo. Si no, simplemente abre el archivo `index.html` en tu navegador.

## Uso

-   Accede a la interfaz de usuario a través de tu navegador para gestionar los productos.
-   Usa Postman o cualquier cliente API para probar los endpoints de la API Rest.

## Autores

-   Daniel Souto - Desarrollo inicial
