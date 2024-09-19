package application.repository;

import java.util.Optional; // Adicione esta importação
import org.springframework.data.repository.CrudRepository;
import application.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    // Adicione métodos de consulta personalizados, se necessário
    Optional<Categoria> findByNome(String nome);
}
