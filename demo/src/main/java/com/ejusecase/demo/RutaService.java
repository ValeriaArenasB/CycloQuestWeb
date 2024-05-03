import org.springframework.data.jpa.repository.JpaRepository;

public interface RutaRepository extends JpaRepository<Ruta, Integer> {}

public class RutaService {
    private final RutaRepository rutaRepository;

    public RutaService(RutaRepository repository) {
        this.rutaRepository = repository;
    }

    public List<Ruta> listarRutas() {
        return rutaRepository.findAll();
    }
}