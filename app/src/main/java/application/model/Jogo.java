package application.model;
import java.util.HashSet;
import java.util.Set;

import jakarta.persitence.Column;
import jakarta.persitence.Entity;
import jakarta.persitence.GeneratedValue;
import jakarta.persitence.GerantionType;
import jakarta.persitence.Id;
import jakarta.persitence.OneToMany;
import jakarta.persitence.Table;

@Entity
@Table (name = "jogos")
public class Jogo{
    @Id
    @GeneratedValue(strategy = GerantionType.IDENTIFY)
    private long id;
    @Column (unique = true, nullabel = false)
    private String titulo;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Categoria getCategoria() {
        this.categoria = categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }    
    public Set<Plataforma> getPlataformas() {
        return plataformas;
    }
    public void setPlataformas(Set<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
}
