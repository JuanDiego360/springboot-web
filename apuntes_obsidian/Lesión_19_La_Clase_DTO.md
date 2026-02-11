# Lesión 19: La Clase DTO

## Resumen
Esta lección presentó el patrón **Objeto de Transferencia de Datos (Data Transfer Object)(DTO)**. Los DTO son objetos que transportan datos entre procesos. En este contexto, utilizamos un DTO para estructurar los datos de respuesta, enviando el objeto `Usuario` y una cadena `título` juntos, desacoplados de la estructura interna del Mapa.

## Cambios clave

### 1. Se creó la clase UserDto
Se creó una nueva clase para almacenar los datos que queremos transferir.
**File:** `src/main/java/.../models/dto/UserDto.java`
```java
public class UserDto {
    private String title;
    private User user;
    // Getters and Setters...
}
```

### 2. Controlador REST actualizado
El punto final ahora devuelve un objeto `UserDto` en lugar de un mapa. Spring Boot serializa automáticamente este objeto en JSON.
**File:** `src/main/java/.../controllers/UserRestController.java`
```java
@GetMapping(path = "/details")
public UserDto details() {
    UserDto userDto = new UserDto();
    User user = new User("Juan", "Florez");
    userDto.setUser(user);
    userDto.setTitle("Hola Mundo Sprint boot");
    return userDto;
}
```

### 3. Vista actualizada (para el controlador MVC)
*Nota: La confirmación también mostró cambios en `details.html` para usar `userDto`, lo que implica que el controlador MVC también podría haberse actualizado para usar DTO o pasar un contenedor DTO, aunque la diferencia extraída para `UserController` no se mostró completamente en este contexto específico, la vista espera `userDto`.*

**File:** `src/main/resources/templates/details.html`
```html
<ul>
    <li th:text="${userDto.user.name}"></li>
    <li th:text="${userDto.user.lastname}"></li>
</ul>
```
