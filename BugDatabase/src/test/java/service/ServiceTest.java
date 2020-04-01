package service;

import static org.junit.Assert.*;

import java.util.List;


import exception.ValidationException;
import org.junit.Test;

import model.Product;
import repository.ProductRepository;
import validator.ProductValidator;

public class ServiceTest {
    Service service = new Service(new ProductValidator());

    @Test
    public void testAdd() { // it also tests getAllProducts
        int currentLength = service.getAllProducts().size();
        try {
            service.addProduct("Product test", "Description for this product", 1);
            List<Product> prods = ProductRepository.selectByName("Product test");
            assert (prods.size() > 0);
            assert (currentLength + 1 == service.getAllProducts().size());
            service.deleteProduct("Product test");
        } catch (Exception e) {
            assert (false);
        }
        try {
            service.addProduct("", "", 0);
            assert (false);
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    public void testDelete() {

        try {
            service.addProduct("Product test", "Description for this product", 1);
            int currentLength = service.getAllProducts().size();

            service.deleteProduct("Product test");
            assert (currentLength - 1 == service.getAllProducts().size());
        } catch (ValidationException e) {
            assert (false);
        }

        try {
            service.deleteProduct("Product nonexistent");
            assert (false);
        } catch (ValidationException e) {
            assert (true);
        }
    }

    @Test
    public void testUpdate() {
        try {
            service.addProduct("Product test", "Description for this product", 1);
            List<Product> prodsByName = ProductRepository.selectByName("Product test");


            List<Product> allProds = ProductRepository.getAllProducts();
            assert (prodsByName.size() > 0);
            assert (allProds.size() > 0);

            int toUpdateId = prodsByName.get(0).getIdProduct();
            Product updatedProd = new Product("Product updated", "Description", 1);
            updatedProd.setIdProduct(toUpdateId);
            ProductRepository.updateProduct(updatedProd);

            Product checkUpdate = ProductRepository.selectById(toUpdateId);

            assert(checkUpdate.getName().equals(updatedProd.getName()));
            assert(checkUpdate.getDescription().equals(updatedProd.getDescription()));
            assert(checkUpdate.getFinished() == updatedProd.getFinished());
            service.deleteProduct("Product updated");

        } catch (ValidationException e) {
            assert(false);
        }

    }

}
