# Lesión 53: Implementando inyección de dependencia con anotaciones @Autowired y @Component

Con `@component` se utiliza para marcar una clase como un componente de Spring, es decir, que Spring la va a gestionar como un bean. <br>

Con `@Autowired` se utiliza para inyectar una dependencia en una clase. <br>

Los siguientes son ejemplos de como se implementa, y se coloca en el archivo `/src/main/java/com/juan/springboot/di/app/springboot_di/services/ProductServiceImpl.java`:
```java
@Component
public class ProductServiceImpl implements ProductServices {
    
}
```

```java
@Autowired
private ProductServices productServices;
```
