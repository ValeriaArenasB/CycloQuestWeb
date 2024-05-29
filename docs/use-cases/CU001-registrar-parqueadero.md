# CU001 - Registro de Parqueaderos:

Funcionalidad: Implementar la funcionalidad para registrar un parqueadero.
Descripción: Permite aL administrador registrar un parqueadero en la base de datos con detalles como ubicación, nombre, y capacidad.
Flujo de Eventos:

| Administrador  | Sistema |
|:-------|:---------|
| 1. Ingresa los detalles del parqueadero (nombre, ubicación, capacidad) | |
| | 2. Verifica que no exista un parqueadero con el mismo nombre y ubicación |
| |3. Genera un ID único para el nuevo parqueadero |
| | 4. Almacena el parqueadero con su ID, nombre, ubicación y capacidad |
| | 5. Retorna un mensaje de confirmación del registro 
