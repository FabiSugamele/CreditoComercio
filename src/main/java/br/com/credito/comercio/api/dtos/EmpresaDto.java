package br.com.credito.comercio.api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.validation.constraints.NotEmpty;

@Data
@ToString
@NoArgsConstructor
public class EmpresaDto {

    private int id;
    private String nome;
    private String cnpj;

    @NotEmpty(message = "Por favor informe o nome")
    @Length(min = 3, max = 200, message = "O Nome deve conter de 3 a 200 caracteres")
    public String getNome() {
        return nome;
    }

    @CNPJ(message = "O CNPJ não possui um formato válido")
    @NotEmpty(message = "CNPJ não informado")
    @Length(min = 14, max = 14, message = "O CNPJ deve conter 14 caracteres, usar apenas números")
    public String getCnpj() {
        return cnpj;
    }
}
