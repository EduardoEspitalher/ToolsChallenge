package com.tools.challenge.dto.transation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tools.challenge.dto.ResponseDTO;
import com.tools.challenge.dto.description.DescriptionDTO;
import com.tools.challenge.dto.paymentMethod.PaymentMethodDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO extends ResponseDTO {

    @JsonProperty("cartao")
    private String cardNumber;

    @JsonProperty("descricao")
    private DescriptionDTO description;

    @JsonProperty("formaPagamento")
    private PaymentMethodDTO paymentMethod;

}
