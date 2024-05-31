document.getElementById('rutaForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const id = document.getElementById('id').value;
    const nombre = document.getElementById('nombre').value;
    const descripcion = document.getElementById('descripcion').value;

    fetch('/rutas', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id, nombre, descripcion })
    })
    .then(response => {
        if (response.ok) {
            alert('Ruta agregada exitosamente');
        } else {
            alert('Error al agregar la ruta');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error al agregar la ruta');
    });
});
