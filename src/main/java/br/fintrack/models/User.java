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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idUsuario;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "senha", nullable = false)
    private String senha;

    public User() {
    }

    public User(Short idUsuario, String email, String nome, Date dataNascimento) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Short getId() {
        return idUsuario;
    }

    public void setId(Short idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUsuario, user.idUsuario) && Objects.equals(email, user.email) && Objects.equals(nome, user.nome) && Objects.equals(dataNascimento, user.dataNascimento) && Objects.equals(senha, user.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, email, nome, dataNascimento);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUsuario=" + idUsuario +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", senha=" + senha +
                '}';
    }
}


