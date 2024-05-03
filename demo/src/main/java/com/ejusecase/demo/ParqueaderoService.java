import org.springframework.data.jpa.repository.JpaRepository;

public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Integer> {
    Parqueadero findByNombre(String nombre);
}

public class ParqueaderoService {
    private final ParqueaderoRepository parqueaderoRepository;

    public ParqueaderoService(ParqueaderoRepository repository) {
        this.parqueaderoRepository = repository;
    }

    public Parqueadero buscarPorNombre(String nombre) {
        return parqueaderoRepository.findByNombre(nombre);
    }
}
