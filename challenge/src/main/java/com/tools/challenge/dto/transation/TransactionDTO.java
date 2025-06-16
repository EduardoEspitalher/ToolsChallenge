package com.tools.challenge.dto.transation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tools.challenge.dto.ResponseDTO;
import com.tools.challenge.dto.description.DescriptionDTO;
import com.tools.challenge.dto.paymentMethod.PaymentMethodDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO extends ResponseDTO {

    @JsonProperty("cartao")
    @NotBlank(message = "O número do cartão é obrigatório")
    private String cardNumber;

    @JsonProperty("descricao")
    @Valid
    private DescriptionDTO description;

    @JsonProperty("formaPagamento")
    @Valid
    private PaymentMethodDTO paymentMethod;

}
