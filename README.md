# API TODO LIST - Spring Boot
Proyecto autodidacta de desarrollo backend

API REST para la gestión de tareas (CRUD).

## Tecnologías utilizadas
- Java
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven

## Funcionalidades
- Crear tareas
- Listar tareas
- Obtener tareas mediante el ID
- Actualizar los datos de una tarea (PATCH)
- Eliminar una tarea

## Características
- Validación de datos de entrada
- Uso de DTOs para garantizar la integridad y evitar la exposición de entidades
- Manejo de excepciones HTTP y respuestas claras hacia el cliente.
- Arquitectura en capas y división de responsabilidades (Controller, Service, Repository)

### Para ejecutarlo
1. Crear la base "tasks_db" en PostgreSQL
2. Ajustar las *application.properties* con las credenciales propias correspondientes
