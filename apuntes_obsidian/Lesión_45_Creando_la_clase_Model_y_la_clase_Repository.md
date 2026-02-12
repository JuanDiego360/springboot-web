# Lesión 45: Creando la clase Model y la clase Repository

## Resumen
En esta clase se nos enseña a crear un modelo llamado `Product` el cual va a tener atributos que son:
- `id`: que es el identificador
- `name`: nombre del producto
- `price`: que es el precio del producto
además se creo una simulación de la base de los datos en `Repositories` y se creo un método para obtener todos los datos que se tiene en la base de datos.

## Cambios clave

### 1. Creación de la clase POJO

En el package `Models` se va a crear una nueva clase de java llamado `Product` el cual va a llevar las siguientes características.

```java
public class Product {

    private Long id;
    private String name;
    private Long price;
	
	// Constructor sin argumentos
	public Product(Long id, String name, Long price) {
    }
    // Constructor
    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
```

## 2. Creamos una simulación de base de datos

Creamos una base de datos en la carpeta: `src\main\java\com\juan\springboot\di\app\springboot_di\repositories\ProductRepository.java` 

```java
public class ProductRepository {

    private List<Product> data;

    // Constructor
    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "Laptop", 1000L),
                new Product(2L, "Mouse", 20L),
                new Product(3L, "Keyboard", 50L),
                new Product(4L, "Monitor", 200L),
                new Product(5L, "Webcam", 50L),
                new Product(6L, "Headphones", 100L),
                new Product(7L, "Microphone", 50L),
                new Product(8L, "Speakers", 100L),
                new Product(9L, "Printer", 200L),
                new Product(10L, "Scanner", 100L));
    }
    // Metodo para obtener todos los productos
    public List<Product> findAll() {
        return data;
    }
}
```

### 3. Implementando método findById en la clase Repository

Creamos un nuevo método para buscar por `id` llamado `findById` 

```java
public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
```

### 4. Escribimos la clase Services

Vamos a crear una clase en `Services` que se llame `ProductService` el cual le vamos a crear los siguientes métodos, en el service se manipulan los datos de la siguiente forma:

```java
public class ProductService {
    private ProductRepository repository = new ProductRepository(); // aquí se crea la conexión con el repositorio (base
                                                                    // de datos o fuente de datos)
    public List<Product> findAll() {
        // aquí se colocarían las reglas de negocio, por ejemplo, filtrar productos
        // por precio, categoría, etc.
        return repository.findAll().stream().map(p -> {
            Double pricDouble = p.getPrice() * 1.25d;
            p.setPrice(pricDouble.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        // aquí se colocarían las reglas de negocio, por ejemplo, filtrar productos
        // por precio, categoría, etc.
        return repository.findById(id);
    }
}
```
### Explicación de la API de Streams en `findAll()`

En la línea:
`return repository.findAll().stream().map(p -> { ... }).collect(Collectors.toList());`

Se están utilizando varias funciones de Java para procesar colecciones de forma funcional:

1.  **`repository.findAll()`**: 
    - Obtiene la colección original de datos (una `List<Product>`). Es el punto de partida.

2.  **`.stream()`**: 
    - Convierte la lista en un **Stream** (flujo de datos). Imagínalo como una tubería donde los elementos pasan uno tras otro para ser procesados uno a uno.

3.  **`.map(p -> { ... })`**: 
    - Es una función de **transformación**. Por cada producto `p` que pasa por el flujo, se ejecuta el código dentro de las llaves. 
    - En este caso, estamos recalculando el precio (`p.getPrice() * 1.25d`) y actualizando el producto. El flujo resultante ahora contiene los productos modificados.

4.  **`.collect(Collectors.toList())`**: 
    - Los Streams son temporales. Esta operación "recoge" todos los elementos que han pasado por la tubería y los guarda en una nueva **Lista** (`List`).

**En resumen:** Tomas la lista -> Creas un flujo -> Modificas los datos -> Guardas el resultado en una nueva lista.

### Comparativa: ¿Qué hace realmente el Stream?

Para entenderlo mejor, comparemos cómo haríamos lo mismo **sin Stream** (usando un bucle tradicional) y **con Stream**. Ambos fragmentos de código logran el mismo resultado final:

#### 1. Enfoque Tradicional (Sin Stream)
Este es el enfoque **imperativo**, donde le decimos paso a paso a la computadora qué hacer:

```java
public List<Product> findAll() {
    // 1. Obtenemos la lista original
    List<Product> products = repository.findAll();
    
    // 2. Creamos una nueva lista para guardar los resultados
    List<Product> newProducts = new ArrayList<>();

    // 3. Recorremos la lista manualmente elemento por elemento
    for (Product p : products) {
        // 4. Aplicamos la lógica (aumento del 25%)
        Double priceWithTax = p.getPrice() * 1.25d;
        p.setPrice(priceWithTax.longValue());
        
        // 5. Agregamos el producto modificado a la nueva lista
        newProducts.add(p);
    }

    // 6. Devolvemos la nueva lista procesada
    return newProducts;
}
```

#### 2. Enfoque con Stream (Funcional)
Aquí usamos un enfoque **declarativo**, donde describimos **qué** queremos conseguir:

```java
public List<Product> findAll() {
    return repository.findAll() // 1. Obtenemos los datos
        .stream()               // 2. Abrimos la "tubería" (el flujo)
        .map(p -> {             // 3. Transformamos cada elemento
            Double pricDouble = p.getPrice() * 1.25d;
            p.setPrice(pricDouble.longValue());
            return p;
        })
        .collect(Collectors.toList()); // 4. Guardamos todo en una nueva lista
}
```

### ¿Cuál es la diferencia clave?

| Característica    | Sin Stream (Bucle `for`)                                   | Con Stream                                             |
| :---------------- | :--------------------------------------------------------- | :----------------------------------------------------- |
| **Estilo**        | **Imperativo**: Describe detalladamente el "cómo" hacerlo. | **Declarativo**: Describe el "qué" quieres que pase.   |
| **Concisión**     | Más verboso (muchas líneas para pasos mecánicos).          | Muy conciso (se enfoca en la lógica).                  |
| **Mantenimiento** | Si quieres filtrar, debes añadir un `if` dentro del `for`. | Si quieres filtrar, solo intercalas un `.filter(...)`. |

El **Stream** funciona como una **cinta transportadora automatizada**: tú instalas las estaciones de trabajo (`map`, `filter`, `sort`) y al final recoges el producto terminado en una caja (`collect`). Sin el Stream, tú tendrías que cargar cada producto de una mesa a otra manualmente usando el bucle `for`.

### 5. Escribimos la clase Controller

Vamos a crear una clase en `controllers` que se llame `SomeControllers` el cual le vamos a crear los siguientes métodos:

```java
@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductService service = new ProductService();
    @GetMapping("/products")
    public List<Product> list() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }
}
```

### Explicación de anotaciones en el Controller

Para que nuestra clase funcione como un punto de acceso a nuestra API, utilizamos estas anotaciones clave de Spring Framework:

1.  **`@RestController`**:
    -   Es la unión de las anotaciones `@Controller` y `@ResponseBody`.
    -   **Su función:** Le indica a Spring que esta clase es un controlador de tipo REST. A diferencia de un controlador tradicional que busca páginas (vistas) HTML, el `@RestController` devuelve los datos directamente en el cuerpo de la respuesta (usualmente en formato **JSON**).

2.  **`@RequestMapping("/api")`**:
    -   Define una ruta base para todas las operaciones dentro de esta clase.
    -   **Su función:** Actúa como un prefijo para las URLs de los métodos. En este caso, todas las rutas de este controlador empezarán con `/api`. 
    -   **Ejemplo:** Para acceder al método `list()`, que tiene el mapeo `/products`, la URL completa será: `localhost:8080/api/products`. Esto ayuda a organizar y versionar tu API de forma profesional.

3. **Métodos HTTP**: Utiliza anotaciones específicas para mapear acciones:

	- `@GetMapping`: Obtener datos.
	- `@PostMapping`: Crear nuevos recursos.
	- `@PutMapping`: Actualizar recursos.
	- `@DeleteMapping`: Eliminar recursos.