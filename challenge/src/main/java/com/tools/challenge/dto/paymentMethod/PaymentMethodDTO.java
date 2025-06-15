package com.tools.challenge.dto.paymentMethod;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tools.challenge.enumeration.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethodDTO {

    @JsonProperty("tipo")
    private PaymentType type;

    @JsonProperty("parcelas")
    private Long installments;
}
