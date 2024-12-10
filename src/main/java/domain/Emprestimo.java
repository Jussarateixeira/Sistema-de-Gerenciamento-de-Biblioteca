package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author Jussara Teixeira
 */
@Entity
public class Emprestimo {

    @Id
    @SequenceGenerator(sequenceName = "seq_emprestimo", name = "seq_emprestimo", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_emprestimo")
    private Long id;
    //Associação com a classe Leitor
    @ManyToOne
    private Leitor leitor;
    //Associação com a classe Livro
    @OneToOne
    private Livro livro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeEmprestimo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataParaDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(Long id, Leitor leitor, Livro livro, Date dataDeEmprestimo, Date dataParaDevolucao) {
        this.id = id;
        this.leitor = leitor;
        this.livro = livro;
        this.dataDeEmprestimo = dataDeEmprestimo;
        this.dataParaDevolucao = dataParaDevolucao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public void setDataEmprestimo(Date dataDeEmprestimo) {
        this.dataDeEmprestimo = dataDeEmprestimo;
    }

    public Date getDataParaDevolucao() {
        return dataParaDevolucao;
    }

    public void setDataDevolucao(Date dataParaDevolucao) {
        this.dataParaDevolucao = dataParaDevolucao;
    }

}
