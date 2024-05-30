document.getElementById('registrarEventoForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;
    const fecha = document.getElementById('fecha').value;
    const ubicacion = document.getElementById('ubicacion').value;
    const descripcion = document.getElementById('descripcion').value;

    const evento = {
        nombre: nombre,
        fecha: new Date(fecha),
        ubicacion: ubicacion,
        descripcion: descripcion
    };

    console.log('Registrando evento:', evento);

    fetch('/api/evento', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(evento)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la respuesta del servidor');
        }
        return response.json();
    })
    .then(data => {
        console.log('Evento registrado:', data);
        alert('Evento registrado exitosamente');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Ocurrió un error al registrar el evento');
    });
});
