package com.api.rest_api.repositories.update;


import co.elastic.clients.elasticsearch.core.UpdateRequest;
import co.elastic.clients.elasticsearch.core.UpdateResponse;
import com.api.rest_api.config.ESClientConfig;
import com.api.rest_api.documents.Product;
import com.api.rest_api.helper.Indices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class ProductUpdateRepository implements UpdateRepository<Product> {

    @Autowired
    private ESClientConfig esClientConfig;

    @Override
    public UpdateResponse<Product> update(Product product) {
        // Create an update request
        UpdateResponse<Product> res = null;
        try {
            res = esClientConfig.getEsClient().update(new UpdateRequest.Builder<Product, Product>()
                            .index(Indices.PRODUCT_INDEX)
                            .id(product.getBarcode())
                            .doc(product)
                            .build(),
                    Product.class
            );
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return res;
    }
}
