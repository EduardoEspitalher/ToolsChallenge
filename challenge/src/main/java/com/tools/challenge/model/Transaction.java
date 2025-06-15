package com.tools.challenge.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction extends BaseModel{

    private Long id;

    private String cardNumber;

    private Description description;

    private PaymentMethod paymentMethod;

}
