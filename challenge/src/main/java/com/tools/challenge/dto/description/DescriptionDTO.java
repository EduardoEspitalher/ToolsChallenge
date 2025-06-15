package com.tools.challenge.dto.description;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tools.challenge.enumeration.StatusType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class DescriptionDTO {

    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("dataHora")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateTime;

    @JsonProperty("estabelecimento")
    private String establishment;

    @JsonProperty("codigoAutorizacao")
    private String authorizationCode;

    private StatusType status;

    private String nsu;

}
