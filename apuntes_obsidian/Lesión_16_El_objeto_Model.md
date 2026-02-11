# Lesión 16: El objeto Model

## Resumen
En esta lección, presentamos la interfaz `Model` para pasar datos del Controlador a la Vista (plantilla Thymeleaf). También creamos una clase de modelo `User` para representar datos de dominio, reemplazando atributos de cadena simples.

## Cambios clave

### 1. Modelo de usuario creado
Se creó un nuevo POJO (Plain Old Java Object) para representar a un usuario.
**File:** `src/main/java/.../models/User.java`
```java
public class User {
    private String name;
    private String lastname;
    // Constructor, Getters and Setters...
}
```

### 2. Controlador actualizado para usar el modelo
El controlador ahora instancia un objeto `Usuario` y lo agrega al `Modelo`.
**File:** `src/main/java/.../controllers/UserController.java`
```java
@GetMapping("/details")
public String details(Model model) {
    User user = new User("Juan", "Florez");
    model.addAttribute("title", "Hola Mundo Sprint boot");
    model.addAttribute("user", user); // Passing the user object
    return "details";
}
```

### 3. Vista actualizada (Thymeleaf)
La plantilla HTML actúa como vista y ahora accede a las propiedades del objeto `usuario`.
**File:** `src/main/resources/templates/details.html`
```html
<ul>
    <li th:text="${user.name}"></li>
    <li th:text="${user.lastname}"></li>
</ul>
```
