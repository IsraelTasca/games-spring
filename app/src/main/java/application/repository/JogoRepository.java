package application.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List; // Importação necessária para List
import java.util.Optional;
import application.model.Jogo;

public interface JogoRepository extends CrudRepository<Jogo, Long> {
    // Adicione métodos de consulta personalizados, se necessário
    Optional<Jogo> findByTitulo(String titulo);
    
    // Se precisar, você pode adicionar métodos para buscar por categoria ou outras propriedades
    List<Jogo> findByCategoriaId(Long categoriaId);
}
