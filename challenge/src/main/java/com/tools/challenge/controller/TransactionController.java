package com.tools.challenge.controller;

import com.tools.challenge.dto.WrapperDTO;
import com.tools.challenge.dto.WrapperListDTO;
import com.tools.challenge.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final PaymentService service;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody WrapperDTO dto) {
        service.save(dto.getTransaction());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<WrapperListDTO> list() {
        var result = service.list();
        return ResponseEntity.ok(
                WrapperListDTO.builder().transaction(result).build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<WrapperDTO> getById(@PathVariable("id") Long id) {
        var result = service.findById(id);
        return ResponseEntity.ok(new WrapperDTO(result));
    }

}
