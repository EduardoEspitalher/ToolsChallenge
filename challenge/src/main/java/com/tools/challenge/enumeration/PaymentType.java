package com.tools.challenge.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PaymentType {
    @JsonProperty("AVISTA")
    AVISTA,

    @JsonProperty("PARCELADO LOJA")
    PARCELADO_LOJA,

    @JsonProperty("PARCELADO EMISSOR")
    PARCELADO_EMISSOR

}
