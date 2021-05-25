package br.com.supera.game.store.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Checkout {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "O nome é obrigatório")
    private String name;

    @NotEmpty(message = "O cpf é obrigatório")
    @Length(min=11,max=11, message = "O número de caracteres é inválido")
    private String cpf;

    @NotEmpty(message = "O número de cartão deve ser informado")
    private String creditCard;

    @NotEmpty(message = "O endereço deve ser informado")
    private String endereco;

    private BigDecimal total;

    private Date createAt ;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Checkout(){}

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
