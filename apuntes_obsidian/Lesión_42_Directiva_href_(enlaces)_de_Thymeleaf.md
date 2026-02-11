# Lesión 42: Directiva href (enlaces) de Thymeleaf

## Resumen


## Cambios clave

### 1. Crear una ruta de enlace
En este archivo se va a colocar una ruta de enlace en el archivo: `src\main\resources\templates\details.html`

```html
<a th:href="@{/list}">Volver al listado</a> <br>
<a th:href="@{'/api/var/values'}">Ver valores de variables de entorno</a> <br>
<a th:href="@{'/api/params/foo?message=hola ' + ${user.name} }">pasar parámetros a foo</a> <br>
<a th:href="@{'/api/var/bar(text=${user.name}, code=10)'}">Ver valores de variables de entorno con parámetros</a>
```
- con Thymeleaf es con `th:href` 
- el símbolo `$` es para los objetos, para variables
- en esta parte el `@` es para rutas URL
- las etiquetas `<a></a>` sirve para generar una ruta de enlace

Con estas etiquetas me generan lo siguiente:
![[captura_pantalla_etiquetas.png]]

si nos fijamos con el `@{/list}` le decimos a que ruta URL que queremos redirigir y para pasarle una variable a la ruta del enlace lo colocamos con una cocatenación de strings,

#### 1.1 para el caso del path variable

Para este demostrativo vamos a agarrar dos variables de entorno diferentes, archivo: `src\main\java\com\juan\curso\springboot\webapp\springboot_web\controllers\PathVariableController.java`

```java
@GetMapping("/baz/{message}") // esto es para que el nombre de la variable sea diferente al nombre del // parametro
public ParamDto baz(@PathVariable(name = "message") String messageOtro) {

        ParamDto param = new ParamDto();
        param.setMessage(messageOtro);
        return param;
    }
```

estas son las dos formas de pasarle parámetros al GetMapping de `/baz` 

```html
<a th:href="@{'/api/var/baz/Hola esto es una prueba '}">Ver valores de variables de entorno con parámetros path variable</a> <br>
<a th:href="@{'/api/var/baz/Hola ' + ${user.name} }">Ver valores de variables de entorno con parámetros path variable con concatenación de variables</a>
```
