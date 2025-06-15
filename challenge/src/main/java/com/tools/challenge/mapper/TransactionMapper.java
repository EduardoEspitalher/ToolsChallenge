package com.tools.challenge.mapper;


import com.tools.challenge.dto.transation.TransactionDTO;
import com.tools.challenge.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionDTO toDTO(Transaction entity);

    Transaction fromDTO(TransactionDTO dto);


}
