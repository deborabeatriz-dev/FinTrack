package br.fintrack.models;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
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
    @Column(name = "idUsuario", nullable = false)
    private short idUsuario;

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

    public short getIdUsuario() {return idUsuario;}

    public void setIdUsuario(short idUsuario) {this.idUsuario = idUsuario;}


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimentacao that = (Movimentacao) o;
        return idUsuario == that.idUsuario && Objects.equals(movimentacaoId, that.movimentacaoId) && Objects.equals(data_movimentacao, that.data_movimentacao) && Objects.equals(valor, that.valor) && Objects.equals(classe, that.classe) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movimentacaoId, idUsuario, data_movimentacao, valor, classe, status);
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "movimentacaoId=" + movimentacaoId +
                ", idUsuario=" + idUsuario +
                ", data_movimentacao=" + data_movimentacao +
                ", valor=" + valor +
                ", classe='" + classe + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
