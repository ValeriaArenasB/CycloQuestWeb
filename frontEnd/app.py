from flask import Flask, render_template, request, redirect, url_for, jsonify
import requests

app = Flask(__name__)



SPRING_BOOT_API_URL = "http://localhost:8080/api/"  # Cambia esta URL si tu API de Spring Boot está en otra dirección

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/api/rutas', methods=['POST'])
def grabar_ruta():
    id = request.form['id']
    nombre = request.form['nombre']
    descripcion = request.form['descripcion']

    # Crea el diccionario de datos de la nueva ruta
    nueva_ruta = {
        "id": id,
        "nombre": nombre,
        "descripcion": descripcion
    }

    # Envía los datos a la API de Spring Boot usando requests
    response = requests.post(SPRING_BOOT_API_URL, json=nueva_ruta)
    
    if response.status_code == 200:
        return redirect(url_for('index'))
    else:
        return jsonify({"error": "No se pudo enviar la ruta"}), response.status_code

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
