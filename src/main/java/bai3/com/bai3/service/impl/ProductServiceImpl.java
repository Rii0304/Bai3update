package bai3.com.bai3.service.impl;

import bai3.com.bai3.domain.UpSertProduct;
import bai3.com.bai3.entity.ProductEntity;
import bai3.com.bai3.repository.ProductRepository;
import bai3.com.bai3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void create(UpSertProduct product) throws IOException {
        ProductEntity entity = new ProductEntity();
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setImagePath(generateImagePath(product.getFile()));
        repository.save(entity);
    }

    private String generateImagePath(MultipartFile file) throws IOException {
        String fileExtension = getFileExtension(file.getOriginalFilename());

        File file1 = new File("C:\\Users\\ADMIN\\IdeaProjects\\Bai3\\images\\" + file.getOriginalFilename());

        try (OutputStream os = new FileOutputStream(file1)) {
            os.write(file.getBytes());
        }

        return file1.getAbsolutePath();
    }


    private String getFileExtension(String originalFilename) {
        return "";
    }
}
