package br.fintrack.models;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short movimentacaoId;

    @OneToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    User idUsuario;

    @Column(name = "dataMovimentacao", nullable = false)
    private Date data_movimentacao;

    @Column(name = "valorMovimentacao", nullable = false)
    private Float valor;

    @Column(name = "classe", nullable = false)
    private String classe;

    @Column(name = "status", nullable = false)
    private String status;

    public Movimentacao() {
    }

    public Movimentacao(Short movimentacaoId, Date dataMovimentacao, Float valor, String classe, String status) {
        this.movimentacaoId = movimentacaoId;
        this.data_movimentacao = dataMovimentacao;
        this.valor = valor;
        this.classe = classe;
        this.status = status;
    }

    public Short getMovimentacaoId() {
        return movimentacaoId;
    }

    public void setMovimentacaoId(Short movimentacaoId) {
        this.movimentacaoId = movimentacaoId;
    }

    public Date getDataMovimentacao() {
        return data_movimentacao;
    }

    public void setDataMovimentacao(Date data_movimentacao) {
        this.data_movimentacao = data_movimentacao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
