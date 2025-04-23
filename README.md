# Marvel API - Proyecto Java con Spring Boot

Este proyecto fue desarrollado como parte de una evaluación técnica. Consiste en una API REST construida con **Java y Spring Boot**, que se conecta con la API pública de **Marvel** para obtener información sobre personajes, cómics y series.

---

## 🚀 Objetivo del Proyecto

Crear un sistema backend que:

- Se integre con la **API de Marvel**.
- Permita gestionar (consultar y almacenar) datos de personajes, cómics y series.
- Incluya autenticación de usuarios.
- Exponga endpoints REST para interactuar con los datos.

---

## 🧰 Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Security
- Maven
- MySQL
- Marvel API

---

## 📦 Clonación y Ejecución del Proyecto

### 1. Clonar el repositorio:

```bash
git clone https://github.com/AgusSanticchia/Marvel-API.git
```

### 2. Acceder al proyecto:

```bash
cd Marvel-API
```

### 3. Configurar el archivo `application.properties`:

Debés configurar:

- La conexión a tu base de datos MySQL.
- Las claves públicas y privadas que obtendrás desde [https://developer.marvel.com/](https://developer.marvel.com/).

Ejemplo de configuración:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/marvel_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

marvel.api.publicKey=TU_CLAVE_PUBLICA
marvel.api.privateKey=TU_CLAVE_PRIVADA
```

### 4. Ejecutar la aplicación:

```bash
./mvnw spring-boot:run
```

La aplicación se ejecutará por defecto en [http://localhost:8080](http://localhost:8080)

---

## 🔐 Seguridad y Roles

El proyecto usa **Spring Security** y JWT para proteger los endpoints.

- **CUSTOMER**: Puede consultar personajes, cómics, y su historial.
- **ADMIN**: Acceso completo, incluyendo historial de todos los usuarios.

---

## 📌 Endpoints Principales (ejemplos)

- `GET /api/personajes` → Lista todos los personajes almacenados.
- `GET /api/personajes?nombre=Spider` → Busca personajes por nombre.
- `GET /api/personajes/{id}` → Detalle de un personaje por ID.
- `GET /api/comics` → Lista todos los cómics.
- `GET /api/comics/{id}` → Detalle de un cómic.
- `GET /api/series` → Lista todas las series.
- `GET /api/series/{id}` → Detalle de una serie.
- `GET /api/historial` → Historial de búsquedas del usuario logueado.

---

## 📄 Recursos Útiles

- [Portal de Desarrolladores de Marvel](https://developer.marvel.com/)
- [Documentación de Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL Docs](https://dev.mysql.com/doc/)
