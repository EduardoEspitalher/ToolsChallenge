package com.tools.challenge.model;

import com.tools.challenge.enumeration.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethod {

    private PaymentType type;

    private Long installments;
}
