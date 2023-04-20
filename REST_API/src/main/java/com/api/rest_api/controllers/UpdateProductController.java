package com.api.rest_api.controllers;

import com.api.rest_api.documents.Product;
import com.api.rest_api.services.ProductUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/update")
public class UpdateProductController {

    @Autowired
    private ProductUpdateService updateService;

    @PostMapping("/product")
    public ResponseEntity<Object> update(@RequestBody Product product) {
        System.out.println(product);
        return ResponseEntity.ok(updateService.updateDocument(product));
    }
}
