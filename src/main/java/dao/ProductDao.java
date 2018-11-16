package dao;

import object.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductDao {

    private Map<Integer, Product> productsDb = new HashMap<>();
    {
        productsDb.put(1, new Product(1, "", "", "", "", 30));
        productsDb.put(2, new Product(2, "", "", "", "", 30));
        productsDb.put(3, new Product(3, "", "", "", "", 30));
        productsDb.put(4, new Product(4, "", "", "", "", 30));
        productsDb.put(5, new Product(5, "", "", "", "", 30));
        productsDb.put(6, new Product(6, "", "", "", "", 30));
        productsDb.put(7, new Product(7, "", "", "", "", 30));
        productsDb.put(8, new Product(8, "", "", "", "", 30));
        productsDb.put(9, new Product(9, "", "", "", "", 30));
        productsDb.put(10, new Product(10, "", "", "", "", 30));
    }

    public List<Product> getProductByPrice(double min, double max) {
        return productsDb.entrySet().stream()
                .filter(p -> p.getValue().getPrice() >= min && p.getValue().getPrice() <= max)
                .map(p -> p.getValue()).collect(Collectors.toList());
    }

    public Product getProductById(int id) {
        return productsDb.get(id);
    }
}