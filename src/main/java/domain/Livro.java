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
public class Livro {

    @Id
    @SequenceGenerator(sequenceName = "seq_livro", name = "seq_livro", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_livro")
    private Long id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private Boolean disponivel = true; // Inicia como disponível
    //Construtores

    public Livro() {

    }

    public Livro(Long id, String titulo, String autor, int anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }
    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

}
