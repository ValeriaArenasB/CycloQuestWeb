# Diagrama de clases Dominio

![](https://www.plantuml.com/plantuml/png/ZP6nJiCm48PtFyKf2wLI8x4Y57Ke0n925Jp1nRw6arAxdEqkYAVY4NWnpl4G0WFTSbzE_dz_tiQ4al9nD7R4666FyfO97Kc0TmF03cxXmISQI7JquTWBANf9mdvGOl64bXqkztBFLd7mywfIeO5Z4fJLjV9pOAUmpz6Yx8CyJMUlVaNevizIviEOAzZHWJrR_lhqu0X6XDAUu3adh1UPFY-xWQDeXKz_sevSt9HpujJtKUUxCdQbH4svFvDFbvcQdVmR3d0W-ueATfXeOQu6plwqIKNDJGFhZTjqqAoRAgB-WBQLjkqM4hVadRxvDm00)


---
```uml
@startuml

class Parqueadero {
  id : Integer
  nombre : String
  capacidad : Integer
  ubicacion : String

  registrar() : void
  buscarPorNombre(nombre : String) : Parqueadero
}

class Ruta {
  id : Integer
  nombre : String
  descripcion : String

  listarRutas() : List<Ruta>
}

class Evento {
  id : Integer
  nombre : String
  ubicacion : String
  descripcion : String
  fecha : Date

  registrarEvento() : void
}

@enduml
```