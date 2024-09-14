package application.model;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GerantionType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "plataformas")
public class Plataforma{
    @Id
    @GeneratedValue(strategy = GerantionType.IDENTIFY)
    private long id;
    @Column (unique = true, nullabel = false)
    private String nome;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public Set<Jogo> getJogos(){
        return jogos;
    }     
    public void setJogos(Set<Jogo> jogos){
        this.jogos = jogos;
    }    
    
}
