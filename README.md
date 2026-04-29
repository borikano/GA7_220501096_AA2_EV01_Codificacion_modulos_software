# Proyecto JDBC Evidencias SENA

Este proyecto corresponde a una evidencia de codificación en Java utilizando JDBC para realizar conexión con una base de datos MySQL.

El objetivo principal es implementar un módulo funcional que permita realizar operaciones CRUD sobre una tabla de usuarios, aplicando buenas prácticas de codificación, separación por paquetes, uso de clases, métodos y conexión a base de datos mediante JDBC.

## Tecnologías utilizadas

- Java
- Apache NetBeans
- Maven
- MySQL
- XAMPP
- JDBC
- Git
- GitHub

## Base de datos

La base de datos utilizada se llama:

```sql
bbdd_codificacion_ga7
```

La tabla principal del proyecto es:

```sql
usuario
```

## Estructura de la tabla

```sql
CREATE DATABASE IF NOT EXISTS bbdd_codificacion_ga7;

USE bbdd_codificacion_ga7;

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    clave VARCHAR(50) NOT NULL
);
```

## Configuración de conexión

La conexión se realiza mediante JDBC usando la siguiente URL:

```java
jdbc:mysql://localhost:3307/bbdd_codificacion_ga7
```

Datos de conexión local:

```text
Usuario: root
Contraseña:
Puerto MySQL: 3307
```

> Nota: En este proyecto MySQL se configuró en el puerto 3307 debido a que el puerto 3306 estaba ocupado en el entorno local.

## Dependencia Maven

El proyecto utiliza el conector oficial de MySQL para Java:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.7.0</version>
</dependency>
```

## Estructura del proyecto

```text
src/main/java/com/mycompany/jdbc_evidencias_sena
│
├── config
│   └── Conexion.java
│
├── dao
│   └── UsuarioDAO.java
│
├── modelo
│   └── Usuario.java
│
├── prueba
│   └── PruebaFuegoCrud.java
│
└── Jdbc_evidencias_sena.java
```

## Descripción de paquetes

### Paquete `config`

Contiene la clase encargada de centralizar la conexión a la base de datos.

Archivo principal:

```text
Conexion.java
```

### Paquete `modelo`

Contiene la clase que representa la entidad principal del sistema.

Archivo principal:

```text
Usuario.java
```

### Paquete `dao`

Contiene la clase encargada de realizar las operaciones directas sobre la base de datos.

Archivo principal:

```text
UsuarioDAO.java
```

### Paquete `prueba`

Contiene una clase de prueba de fuego para validar el funcionamiento completo del CRUD.

Archivo principal:

```text
PruebaFuegoCrud.java
```

## Funcionalidades implementadas

El sistema permite realizar las siguientes operaciones:

- Insertar usuarios
- Consultar usuarios
- Actualizar usuarios
- Eliminar usuarios

Estas funcionalidades se realizan mediante JDBC y sentencias SQL preparadas con `PreparedStatement`.

## Clase principal

La clase principal del proyecto es:

```text
Jdbc_evidencias_sena.java
```

Desde esta clase se ejecuta un menú de consola con las siguientes opciones:

```text
===== MODULO DE USUARIOS JDBC =====
1. Insertar usuario
2. Consultar usuarios
3. Actualizar usuario
4. Eliminar usuario
5. Salir
```

## Prueba de fuego CRUD

El proyecto incluye una clase de prueba llamada:

```text
PruebaFuegoCrud.java
```

Esta clase realiza automáticamente el siguiente flujo:

1. Inserta tres usuarios de prueba.
2. Consulta los usuarios insertados.
3. Actualiza los tres usuarios.
4. Verifica la actualización.
5. Elimina los usuarios de prueba.
6. Verifica que los usuarios hayan sido eliminados.

Esta prueba permite validar que las operaciones CRUD funcionan correctamente.

## Ejecución del proyecto

Para ejecutar el menú principal desde NetBeans:

```text
Run Project
```

Para ejecutar la prueba de fuego desde NetBeans:

```text
Clic derecho sobre PruebaFuegoCrud.java
Run File
```

También se puede ejecutar desde terminal con Maven:

```bash
mvn exec:java -Dexec.mainClass="com.mycompany.jdbc_evidencias_sena.prueba.PruebaFuegoCrud"
```

## Requisitos previos

Antes de ejecutar el proyecto, se debe verificar que:

1. XAMPP esté abierto.
2. MySQL esté iniciado correctamente.
3. MySQL esté funcionando en el puerto 3307.
4. La base de datos `bbdd_codificacion_ga7` exista.
5. La tabla `usuario` exista.
6. El proyecto tenga descargada la dependencia `mysql-connector-j`.

## Versionamiento

El proyecto fue desarrollado utilizando Git como herramienta de versionamiento.

Se realizaron commits separados para evidenciar el proceso de construcción del proyecto:

```text
chore: initialize Java Maven project
feat: add MySQL JDBC connection
feat: add Usuario model
feat: implement Usuario DAO CRUD operations
feat: add console menu for Usuario CRUD
test: add CRUD smoke test with three users
docs: add project README
```

## Autor

Proyecto desarrollado como evidencia de formación en construcción de aplicaciones con Java y conexión a base de datos mediante JDBC.
