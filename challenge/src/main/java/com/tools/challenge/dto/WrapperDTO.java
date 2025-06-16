package com.tools.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tools.challenge.dto.transation.TransactionDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WrapperDTO {

    @JsonProperty("transacao")
    @Valid
    TransactionDTO transaction;

}
