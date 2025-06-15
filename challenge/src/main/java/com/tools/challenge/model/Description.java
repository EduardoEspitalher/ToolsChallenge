package com.tools.challenge.model;

import com.tools.challenge.enumeration.StatusType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Description {

    private BigDecimal value;

    @CreatedDate
    private LocalDateTime dateTime;

    private String establishment;

    private String nsu;

    private String authorizationCode;

    private StatusType status;

}
