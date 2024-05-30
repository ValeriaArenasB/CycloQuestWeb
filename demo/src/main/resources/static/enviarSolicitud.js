document.getElementById('parqueaderoForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const nombre = document.getElementById('name1').value;
    const ubicacion = document.getElementById('name2').value;
    const capacidad = document.getElementById('name3').value;

    fetch('/api/parqueadero', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre, ubicacion, capacidad })
    })
    .then(response => {
        if (response.ok) {
            alert('Parqueadero agregado exitosamente');
        } else {
            alert('Error al agregar el parqueadero');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al agregar el parqueadero');
    });
});
