package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;

@SpringBootTest
public class MapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testGetAllProducts() {

        List<Product> products = productMapper.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("No products found in the database.");
        } else {
            System.out.println("Products List:");

            products.forEach(product -> {
                System.out.println("--------------------------------");
                System.out.println("Product ID: " + product.getProductsid());
                System.out.println("Product Name: " + product.getProductsname());
                System.out.println("Price: " + product.getProductsprice());
                System.out.println("Description: " + product.getProductsdescribe());
                System.out.println("Image URL: " + product.getProductspic());
            });
            System.out.println("--------------------------------");
        }
    }

    @Test
    public void testGetProductById() {
        int productId = 1;
        Product product = productMapper.getProductById(productId);

        if (product == null) {
            System.out.println("產品 ID 有誤: " + productId);
        } else {
            System.out.println("產品明細:");
            System.out.println("--------------------------------");
            System.out.println("Product ID: " + product.getProductsid());
            System.out.println("Product Name: " + product.getProductsname());
            System.out.println("Price: " + product.getProductsprice());
            System.out.println("Description: " + product.getProductsdescribe());
            System.out.println("Image URL: " + product.getProductspic());
            System.out.println("--------------------------------");
        }
    }

    @Test
    public void testInsertProduct() {
        Product newProduct = new Product();
        newProduct.setProductsname("New Product");
        newProduct.setProductsprice(999);
        newProduct.setProductsdescribe("This is a newly added product.");
        newProduct.setProductspic("http://example.com/image.jpg");

        int result = productMapper.insertProduct(newProduct);
        if (result > 0) {
            System.out.println("產品新增成功. Product ID: " + newProduct.getProductsid());
        } else {
            System.out.println("產品新增失敗");
        }
    }

    @Test
    public void testUpdateProduct() {
        int productId = 33;
        Product productToUpdate = productMapper.getProductById(productId);

        if (productToUpdate != null) {
            productToUpdate.setProductsname("Updated Product Name");
            productToUpdate.setProductsprice(1234);
            productToUpdate.setProductsdescribe("Updated description.");
            productToUpdate.setProductspic("http://example.com/updated-image.jpg");

            int result = productMapper.updateProduct(productToUpdate);
            if (result > 0) {
                System.out.println("產品更新成功");
            } else {
                System.out.println("產品更新失敗");
            }
        } else {
            System.out.println("產品 ID 有誤: " + productId);
        }
    }

    @Test
    public void testDeleteProduct() {
        int productId = 34;
        int result = productMapper.deleteProduct(productId);

        if (result > 0) {
            System.out.println("產品刪除成功");
        } else {
            System.out.println("產品刪除失敗");
        }
    }

}
