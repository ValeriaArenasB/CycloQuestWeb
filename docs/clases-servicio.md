# Diagrama de clases Servicio

![](https://www.plantuml.com/plantuml/png/dLBBJiGm3BpdAwoUkg0zS5sXrHxWW8JGYlq2Dp4bKfiM9-a5yU-a3oar3rHnIkpCsEE9JpuWXzWsIZVeFPoHtoAX8Uukn8FL1EyAu1gOQki38wyGPP_lS5XpToaSEcicQXMz5hnpnqzTMp6LRZeI-1BOkdedgwWFjSXwZW6bdiQEoiUyBqVQOufln_2OMVS3kV3R7FDZITC1XncSXIz5X2DJ2MiIvC45gebJ-6M2bD7OexO69IvMLgTqvp9KGLPJPiSMl_vdqZQ9Xhncst-JiztKRNtaq7yr1tWX_OefSOU1iZNvezO_yyEM5ZS5xFTGN1LhSnAd9XzIAuIZobiay6DQ0jUB8w3pWmIVo9dODfy0)

---

```uml
@startuml

class ParqueaderoService {
  + registrarParqueadero(parqueadero : Parqueadero) : void
  + buscarParqueaderoPorNombre(nombre : String) : Parqueadero
}

class RutaService {
  + listarRutas() : List<Ruta>
}

class EventoService {
  + registrarEvento(evento : Evento) : void
}

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

ParqueaderoService "1" -- "*" Parqueadero : gestiona >
RutaService "1" -- "*" Ruta : gestiona >
EventoService "1" -- "*" Evento : gestiona >

@enduml
```