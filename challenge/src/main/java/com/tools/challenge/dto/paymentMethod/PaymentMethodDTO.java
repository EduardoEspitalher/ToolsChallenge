package com.tools.challenge.dto.paymentMethod;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tools.challenge.enumeration.PaymentType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethodDTO {

    @JsonProperty("tipo")
    @NotNull(message = "O tipo de pagamento é obrigatório")
    private PaymentType type;

    @JsonProperty("parcelas")
    @NotNull(message = "O número de parcelas é obrigatório")
    @Min(value = 1, message = "O número de parcelas deve ser no mínimo 1")
    private Long installments;
}
