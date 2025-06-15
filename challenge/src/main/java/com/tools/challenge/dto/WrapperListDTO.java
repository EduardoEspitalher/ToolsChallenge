package com.tools.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tools.challenge.dto.transation.TransactionDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class WrapperListDTO {

    @JsonProperty("transacoes")
    List<TransactionDTO> transaction;
}
