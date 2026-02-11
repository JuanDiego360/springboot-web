# Lesión 45: Creando la clase Model y la clase Repository

## Resumen


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

