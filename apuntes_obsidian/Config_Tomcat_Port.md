# Configuración: Tomcat Port

## Resumen
Este cambio demuestra cómo configurar el puerto del servidor Tomcat integrado utilizando el archivo `application.properties`.

## Key Changes

### 1. Changed Server Port
El puerto predeterminado (8080) se cambió a 8090.
**File:** `src/main/resources/application.properties`
```properties
spring.application.name=springboot-web
server.port=8090
```
