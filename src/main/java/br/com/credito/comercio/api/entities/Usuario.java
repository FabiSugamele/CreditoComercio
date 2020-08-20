package br.com.credito.comercio.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Usuario {

    private int id;
    private String nome;
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
