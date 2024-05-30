document.getElementById('buscarRutaForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;

    console.log('Buscando rutas con el nombre:', nombre);

    fetch(`/api/ruta/buscar?nombre=${encodeURIComponent(nombre)}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error en la respuesta del servidor');
            }
            return response.json();
        })
        .then(data => {
            console.log('Resultados de la búsqueda:', data);

            const resultadosDiv = document.getElementById('resultados');
            resultadosDiv.innerHTML = '';

            if (data.length > 0) {
                data.forEach(ruta => {
                    const rutaDiv = document.createElement('div');
                    rutaDiv.classList.add('ruta');

                    const nombreRuta = document.createElement('h3');
                    nombreRuta.textContent = ruta.nombre;

                    const descripcionRuta = document.createElement('p');
                    descripcionRuta.textContent = `Descripción: ${ruta.descripcion}`;

                    rutaDiv.appendChild(nombreRuta);
                    rutaDiv.appendChild(descripcionRuta);

                    resultadosDiv.appendChild(rutaDiv);
                });
            } else {
                resultadosDiv.textContent = 'No se encontraron rutas.';
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
});
