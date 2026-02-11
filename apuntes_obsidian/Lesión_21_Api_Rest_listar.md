# Lesión 21: Api Rest listar

## Resumen
En esta lección, creamos un nuevo punto final REST para devolver una lista de usuarios (matriz JSON).

## Cambios claves

### 1. lista añadido de Endpoint
Se agregó un nuevo método `list()` al controlador REST.
**File:** `src/main/java/.../controllers/UserRestController.java`
```java
@GetMapping(path = "/list")
public List<User> list() {
    User user = new User("Juan", "Florez");
    User user2 = new User("Ana", "Gomez");
    // ... creating more users
    List<User> users = Arrays.asList(user, user2, user3, user4, user5);
    return users;
}
```
*Note: This endpoint returns a JSON array of user objects.*
