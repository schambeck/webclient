package com.jobsity.webclient.service;

import com.jobsity.webclient.domain.Invoice;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class InvoiceFluxService {

    private final WebClient client;

    public InvoiceFluxService(WebClient client) {
        this.client = client;
    }

    public Flux<Invoice> findAll() {
        return client.get()
                .uri("/invoices")
                .retrieve()
                .bodyToFlux(Invoice.class);
    }

}