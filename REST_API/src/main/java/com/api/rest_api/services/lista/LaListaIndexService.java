package com.api.rest_api.services.lista;

import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.api.rest_api.documents.domain.LaLista;
import com.api.rest_api.repositories.index.LaListaIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LaListaIndexService {

    @Autowired
    private LaListaIndexRepository laListaIndexRepository;

    public IndexResponse indexLista(String email, String listName) {

        return laListaIndexRepository.indexDocument(LaLista.builder()
                .name(listName)
                .email(email)
                .date(LocalDate.now().toString())
                .build());
    }

    public boolean createIndex() {
        return laListaIndexRepository.createIndex();
    }

}
