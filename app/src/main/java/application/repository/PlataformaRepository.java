package application.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List; // Importação necessária para List
import java.util.Optional;
import application.model.Plataforma;

public interface PlataformaRepository extends CrudRepository<Plataforma, Long> {
    // Adicione métodos de consulta personalizados, se necessário
    Optional<Plataforma> findByNome(String nome);
    
    // Se precisar, você pode adicionar métodos para buscar plataformas relacionadas a jogos, se necessário
    List<Plataforma> findByJogos_Id(Long jogoId);
}
