package br.com.credito.comercio.api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@ToString
@NoArgsConstructor
public class UsuarioDto {

    private int id;
    private String nome;
    private String email;

    @NotEmpty(message = "Por favor informe o nome")
    @Length(min = 3, max = 200, message = "O Nome deve conter de 3 a 200 caracteres")
    public String getNome() {
        return nome;
    }

    @Email(message = "O email não possui um formato válido")
    @NotEmpty(message = "Email não informado")
    @Length(min = 5, max = 200, message = "O Email deve conter de 5 a 200 caracteres")
    public String getEmail() {
        return email;
    }
}
