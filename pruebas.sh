#!/bin/bash

echo "Agregar Parqueadero"
http POST :8080/api/parqueadero nombre='Parqueadero Central' ubicacion='Calle 123' capacidad=50

echo "Listar todos los Parqueaderos"
http GET :8080/api/parqueadero

echo "Obtener Parqueadero por ID"
http GET :8080/api/parqueadero/1

echo "Actualizar Parqueadero por ID"
http PUT :8080/api/parqueadero/1 nombre='Parqueadero Modificado' ubicacion='Calle 456' capacidad=100

echo "Eliminar Parqueadero por ID"
http DELETE :8080/api/parqueadero/1

echo "Agregar Ruta"
http POST :8080/api/ruta nombre='Ruta del Lago' descripcion='Ruta escénica alrededor del lago'

echo "Listar todas las Rutas"
http GET :8080/api/ruta

echo "Obtener Ruta por ID"
http GET :8080/api/ruta/1

echo "Actualizar Ruta por ID"
http PUT :8080/api/ruta/1 nombre='Ruta Modificada' descripcion='Ruta modificada alrededor del lago'

echo "Eliminar Ruta por ID"
http DELETE :8080/api/ruta/1

echo "Agregar Evento"
http POST :8080/api/evento nombre='Maratón Bici' descripcion='Evento de ciclismo para todas las edades' ubicacion='Parque Central' fecha='2024-06-15T09:00:00.000+00:00'

echo "Listar todos los Eventos"
http GET :8080/api/evento

echo "Obtener Evento por ID"
http GET :8080/api/evento/1

echo "Actualizar Evento por ID"
http PUT :8080/api/evento/1 nombre='Maratón Bici Modificado' descripcion='Evento modificado de ciclismo' ubicacion='Parque Este' fecha='2024-06-20T09:00:00.000+00:00'

echo "Eliminar Evento por ID"
http DELETE :8080/api/evento/1
