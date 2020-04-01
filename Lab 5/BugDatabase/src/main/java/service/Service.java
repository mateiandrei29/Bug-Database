package service;

import java.util.List;


import exception.ValidationException;
import model.Product;
import repository.ProductRepository;
import validator.ProductValidator;

public class Service {

    private ProductValidator prodVal;

    public Service(ProductValidator prodVal) {

        this.prodVal = prodVal;
    }

    public void addProduct(String name, String description, int finished) throws ValidationException {
        Product p = new Product(name, description, finished);
        prodVal.validate(p);
        ProductRepository.insertProduct(p);
    }

    public void deleteProduct(String nameDelete) throws ValidationException {
        if (nameDelete.equals(""))
            throw new ValidationException("Name is empty.");
        List<Product> products = ProductRepository.selectByName(nameDelete);
        if (products.size() > 0)
            ProductRepository.deleteProduct(products.get(0).getIdProduct());
        else
            throw new ValidationException("Product not found in database");
    }

    public void updateProduct(String toUpdate, String nameUp, String descriptionUp, int finishedUp) throws ValidationException {

        List<Product> products = ProductRepository.selectByName(toUpdate);
        if (products.size() > 0) {
            Product p = new Product(nameUp, descriptionUp, finishedUp);
            p.setIdProduct(products.get(0).getIdProduct());
            prodVal.validate(p);
            ProductRepository.updateProduct(p);
        }
    }

    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        return ProductRepository.getAllProducts();

    }
}
