# ☕ CafeTrack - Gestión de Precios de Café

**CafeTrack** es un sistema backend en Java con Spring Boot que permite registrar, consultar y analizar precios de café tanto a nivel **local** como **internacional**, con posibilidad de integrar fuentes externas como API Ninjas o Twelve Data.

## 📦 Estructura del Proyecto

backend/
├── controller/ # Controladores REST
├── dto/ # Objetos de transferencia de datos (DTO)
├── model/ # Entidades JPA
├── repository/ # Interfaces de acceso a datos
├── service/ # Lógica de negocio
├── shared/config/ # Configuraciones externas (WebClient, API)
└── resources/
└── application.properties


## ⚙️ Tecnologías Usadas

- **Java 21**
- Spring Boot 3.5.3
- Spring Web + Reactive Web (WebClient)
- Spring Data JPA
- H2 / PostgreSQL / MySQL (según configuración)
- Swagger / OpenAPI 3
- Maven

---

## 🧩 Funcionalidades Implementadas

### 🗓 Registro de precios diarios
- ✅ Se puede guardar un precio local por día.
- ⚠️ El precio internacional es opcional (puede obtenerse de una API externa o ingresarse manualmente).
- ⛔ No se permiten fechas duplicadas.

### 🔍 Consulta de precios
- 🔹 Todos los precios almacenados.
- 🔹 Precio por fecha específica.
- 🔹 Precio local por fecha (solo campo local).
- 🔹 Integración con API externa para obtener el precio internacional (actualmente desactivada o pendiente de ajuste con Twelve Data).

---

## 📂 Entidades y DTOs

### `Precio.java`
Entidad que representa un precio registrado. Contiene:
- `id`: Long
- `fecha`: LocalDate (única)
- `precioLocal`: Double
- `precioInternacional`: Double (opcional)

### `CrearPrecioDTO.java`
DTO para recibir los datos de entrada al crear un precio.

### `PrecioDTO.java`
DTO para exponer los precios en las respuestas del API.

---

## 🔌 Endpoints REST (Swagger UI)

Disponible en:  
👉 `http://localhost:8080/swagger-ui/index.html`

### 📥 POST `/api/precios`
Registrar un nuevo precio:
```json
{
  "fecha": "2025-06-23",
  "precioLocal": 125000.0,
  "precioInternacional": 1.45
}

📤 GET /api/precios/api/get_precios

Listar todos los precios registrados.
🔎 GET /api/precios/fecha/{fecha}

Buscar un precio completo (local + internacional) por fecha.
☁️ GET /api/precios/externo

Obtener precio internacional desde API externa (actualmente usando Ninja o pendiente con Twelve Data).
📆 GET /api/precios/local?fecha=2025-06-23

Consultar solo el precio local para una fecha específica.
⚠️ Problemas conocidos

    El consumo de la API externa (Ninjas o Twelve Data) puede fallar por:

        ❌ Errores de SSL

        🔐 Restricciones por plan "Premium"

        ⚙️ Parámetros de symbol incorrectos

    La propiedad commodities-api.key debe definirse en application.properties si se usa WebClient.

▶️ Cómo correr el proyecto
Requisitos

    Java 21

    Maven

Comandos

# Compilar el proyecto
mvn clean install

# Ejecutar localmente
mvn spring-boot:run

📝 Pendientes / Siguientes pasos

Configurar correctamente Twelve Data como fuente externa.

Implementar autenticación de usuarios.

Agregar validaciones a nivel DTO con javax.validation.

Configurar base de datos PostgreSQL en producción.

    Exportación de precios a Excel o PDF.

📫 Contacto

Desarrollado por Jose David Arias Pantoja
Estudiante de Ingeniería en Sistemas
