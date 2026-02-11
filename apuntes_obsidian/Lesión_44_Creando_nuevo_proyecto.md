# Lesión 44: Creando nuevo proyecto

## Resumen
En esta lesión se crea un nuevo proyecto de Spring Boot, es el segundo proyecto (proyecto2).

## Cambios clave

las dependencias que se usan son:

- `spring-boot-spring-web`
- `spring-boot-devtools`
- `spring-boot-actuator`

## 1. Creación de un nuevo package
Creación de paquetes:
desde aqui:
![[creaciondelospaquetes.png]]

los paquetes que creamos son:
- `src\main\java\com\juan\springboot\di\app\springboot_di\controllers`  →  maneja los métodos handle, la petición de los usuarios, devolver la vista o la respuesta el JSON
- `src\main\java\com\juan\springboot\di\app\springboot_di\models`  → 
- `src\main\java\com\juan\springboot\di\app\springboot_di\services`  → interactúan con los repositorios
- `src\main\java\com\juan\springboot\di\app\springboot_di\repositories`  → son los que acceden con los datos, se comunica con la base de datos, hace consultas, operaciones, save, insert
