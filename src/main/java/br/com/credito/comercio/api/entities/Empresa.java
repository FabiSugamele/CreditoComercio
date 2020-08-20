package br.com.credito.comercio.api.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Empresa {

    private int id;
    private String nome;
    private String cnpj;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId(){
        return id;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    @Column(name = "cnpj", nullable = false)
    public String getCnpj() {
        return cnpj;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
