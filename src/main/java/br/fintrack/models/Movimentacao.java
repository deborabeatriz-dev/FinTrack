package br.fintrack.models;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short movimentacaoId;

    @Column(name = "dataMovimentacao", nullable = false)
    private Date data_movimentacao;

    @Column(name = "valorMovimentacao", nullable = false)
    private Float valor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User usuario;
    
    @Transient
    Short idUsuario;

    @Column(name = "status", nullable = false)
    private String status;

    public Movimentacao() {
    }

    public Movimentacao(Short movimentacaoId, Date dataMovimentacao, Float valor, Short idClassificacao, Short idUsuario, User usuario,
            String status) {
        this.movimentacaoId = movimentacaoId;
        this.data_movimentacao = dataMovimentacao;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.valor = valor;
        this.status = status;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Short getIdUsuario() {
        return idUsuario.shortValue();
    }

    public void setIdUsuario(Short idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
