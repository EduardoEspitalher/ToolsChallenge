package com.tools.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tools.challenge.dto.transation.TransactionDTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WrapperDTO {

    @JsonProperty("transacao")
    TransactionDTO transaction;
}
