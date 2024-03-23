package br.fintrack.models;

import java.util.Date;
import java.util.Objects;

public class Movimentacao {
    private Short id;
    private Short userId;
    private Date moveDate;
    private Short value;
    private String classe;
    private String status;

    public Movimentacao() {
    }

    public Movimentacao(Short id, Short userId, Date moveDate, Short value, String classe, String status) {
        this.id = id;
        this.userId = userId;
        this.moveDate = moveDate;
        this.value = value;
        this.classe = classe;
        this.status = status;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }

    public Date getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(Date moveDate) {
        this.moveDate = moveDate;
    }

    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
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
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(moveDate, that.moveDate) && Objects.equals(value, that.value) && Objects.equals(classe, that.classe) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, moveDate, value, classe, status);
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "id=" + id +
                ", userId=" + userId +
                ", moveDate=" + moveDate +
                ", value=" + value +
                ", classe='" + classe + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
