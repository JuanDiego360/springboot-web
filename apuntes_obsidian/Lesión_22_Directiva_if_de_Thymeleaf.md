# Lesión 22: Directiva if de Thymeleaf

## Resumen
This lesson covered how to use conditional logic in Thymeleaf templates using `th:if`. We also added an optional `email` field to the User model.

## Cambios claves

### 1. Modelo de usuario actualizado
Se agregó un campo de `correo electrónico`.
**File:** `src/main/java/.../models/User.java`
```java
private String email;
// Getters and Setters
```

### 2. Controlador actualizado
Establezca el correo electrónico para el objeto de usuario.
**File:** `src/main/java/.../controllers/UserController.java`
```java
user.setEmail("juan@correo.com");
```

### 3. Vista actualizada con condicionales
Se utiliza `th:if` para representar el elemento de la lista de correo electrónico solo si el correo electrónico no es nulo.
**File:** `src/main/resources/templates/details.html`
```html
<li th:if="${user.email != null}" th:text="${user.email}"></li>
<li th:if="${user.email == null}">No existe el correo</li>
```
