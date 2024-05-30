document.getElementById('buscarForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;

    fetch(`/api/parqueadero/buscar?nombre=${encodeURIComponent(nombre)}`)
        .then(response => response.json())
        .then(data => {
            const resultadosDiv = document.getElementById('resultados');
            resultadosDiv.innerHTML = '';

            if (data.length > 0) {
                data.forEach(parqueadero => {
                    const parqueaderoDiv = document.createElement('div');
                    parqueaderoDiv.classList.add('parqueadero');

                    const nombreParqueadero = document.createElement('h3');
                    nombreParqueadero.textContent = parqueadero.nombre;

                    const ubicacionParqueadero = document.createElement('p');
                    ubicacionParqueadero.textContent = `Ubicación: ${parqueadero.ubicacion}`;

                    const capacidadParqueadero = document.createElement('p');
                    capacidadParqueadero.textContent = `Capacidad: ${parqueadero.capacidad}`;

                    parqueaderoDiv.appendChild(nombreParqueadero);
                    parqueaderoDiv.appendChild(ubicacionParqueadero);
                    parqueaderoDiv.appendChild(capacidadParqueadero);

                    resultadosDiv.appendChild(parqueaderoDiv);
                });
            } else {
                resultadosDiv.textContent = 'No se encontraron parqueaderos.';
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
});
