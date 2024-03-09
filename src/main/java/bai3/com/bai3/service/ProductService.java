package bai3.com.bai3.service;

import bai3.com.bai3.domain.UpSertProduct;
import bai3.com.bai3.entity.ProductEntity;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<ProductEntity> getAll();

    void create(UpSertProduct product) throws IOException;
}