package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

/**
 *
 * @author Jussara Teixeira
 */
@Entity
public class Leitor {

    @Id
    @SequenceGenerator(sequenceName = "seq_leitor", name = "seq_leitor", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_leitor")
    private Long id;
    private String nome;
    private String email;

    public Leitor() {
    }

    public Leitor(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
