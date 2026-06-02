# Guía técnica del proyecto EV01

Repositorio: `GA7_220501096_AA2_EV01_Codificacion_modulos_software`

Proyecto académico en Java para la evidencia EV01 de codificación de módulos de software.

Esta guía funciona como panel de revisión para ubicar rápidamente el código fuente, la documentación, la base de datos y la evidencia funcional.

---

## Lectura rápida para revisión

| Elemento | Ubicación | Estado |
|---|---|---|
| Código fuente Java | [`src`](../src) | Disponible |
| Documentación técnica | [`docs`](../docs) | Disponible |
| Evidencia funcional | [`docs/EVIDENCIA_FUNCIONAL.md`](../docs/EVIDENCIA_FUNCIONAL.md) | Disponible |
| Evidencia de consola | [`evidencias/EV01-CRUD-CONSOLA`](../evidencias/EV01-CRUD-CONSOLA) | Disponible |
| README principal | [`README.md`](../README.md) | Disponible |
| Licencia y uso académico | [`LICENSE.md`](../LICENSE.md) | Disponible |

---

## Qué debe revisar el evaluador

| Criterio | Ruta sugerida | Estado |
|---|---|---|
| Modelo de usuario | [`src`](../src) | Completado |
| Conexión JDBC | [`src`](../src) | Completado |
| Operaciones CRUD | [`src`](../src) | Completado |
| Menú de consola | [`src`](../src) | Completado |
| Prueba funcional | [`docs/EVIDENCIA_FUNCIONAL.md`](../docs/EVIDENCIA_FUNCIONAL.md) | Completado |
| Evidencia visible | [`evidencias/EV01-CRUD-CONSOLA`](../evidencias/EV01-CRUD-CONSOLA) | Completado |

---

## Alcance técnico

| Componente | Descripción | Estado |
|---|---|---|
| Lenguaje | Java | Implementado |
| Base de datos | MySQL local | Documentado |
| Acceso a datos | JDBC | Implementado |
| Patrón de acceso | DAO | Implementado |
| Operaciones | Crear, consultar, actualizar y eliminar usuarios | Implementado |
| Prueba | Prueba de fuego con usuarios de ejemplo | Documentado |

---

## Ejecución local

| Paso | Acción |
|---|---|
| 1 | Revisar configuración de base de datos en el proyecto |
| 2 | Crear la base de datos local indicada en la documentación |
| 3 | Ejecutar el proyecto Java desde el entorno configurado |
| 4 | Validar el CRUD desde el menú de consola |

Nota: la configuración local usa MySQL en entorno académico. Los valores como `localhost` y `root` corresponden al ambiente local de desarrollo.

---

## Evidencia funcional

| Evidencia | Ubicación | Estado |
|---|---|---|
| Documento funcional | [`docs/EVIDENCIA_FUNCIONAL.md`](../docs/EVIDENCIA_FUNCIONAL.md) | Disponible |
| Punto de entrada de evidencia | [`evidencias/EV01-CRUD-CONSOLA/README.md`](../evidencias/EV01-CRUD-CONSOLA/README.md) | Disponible |

---

## Seguridad y datos de prueba

| Criterio | Estado |
|---|---|
| Datos reales no requeridos | Cumplido |
| Correos de ejemplo bajo `example.com` | Cumplido |
| Credenciales productivas no versionadas | Cumplido |
| Configuración local documentada | Cumplido |
| Uso académico indicado | Cumplido |

---

## Estado final de revisión

| Criterio | Estado |
|---|---|
| Código fuente visible | Completado |
| Documentación funcional visible | Completado |
| Evidencia disponible | Completado |
| Guía técnica visual | Completado |
| Licencia documentada | Completado |
| Repositorio listo para revisión | Completado |
