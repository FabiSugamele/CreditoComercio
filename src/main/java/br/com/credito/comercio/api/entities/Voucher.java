package br.com.credito.comercio.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "voucher")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Voucher {

    private int id;
    private Empresa empresa;
    private Usuario usuario;
    private double valor;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId(){
        return id;
    }

    @Column(name = "valor", nullable = false)
    public double getValor() {
        return valor;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Empresa getEmpresa() {
        return empresa;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Usuario getUsuario() {
        return usuario;
    }
}
