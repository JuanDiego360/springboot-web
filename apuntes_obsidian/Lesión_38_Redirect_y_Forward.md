# Lesión 38: Retornando redirect y forward

## Resumen
Esta lección explicó la diferencia entre `redirect` y `forward` en los controladores Spring MVC.
- **Forward**: Se realiza internamente en el servidor. La URL en el navegador no cambia.
- **Redirect**: Envía una respuesta al cliente para solicitar una nueva URL. La URL en el navegador cambia.

## Cambios claves

### 1. Controlador de HomeController creado
Un nuevo controlador para manejar la ruta raíz `/` y reenviar solicitudes.
**File:** `src/main/java/.../controllers/HomeController.java`
```java
@Controller
public class HomeController {

    @GetMapping({ "/", "/home", "" })
    public String home() {
        return "forward:/list"; // Forwards to the /list view/endpoint
    }
}
```
