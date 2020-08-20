package br.com.credito.comercio.api.dtos;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@ToString
@NoArgsConstructor
public class LoginDto {

    private String email;

    @NotEmpty(message = "Login não informado")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
