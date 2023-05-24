package com.telusko.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductService {

    @Autowired
    ProductDB db;
    List<Product> products = new ArrayList<>();
    // Add products
    public void addProduct(Product p) {
        db.save(p);
    }

    // Fetching products based on the name of the products
    public List<Product> getProductByName(String name){
        String str = name.toLowerCase();
        List<Product> prods = new ArrayList<>();
        List<Product> prodsList= db.findAll();
        for(Product p : prodsList){
            String productName = p.getName().toLowerCase();
            if(productName.equals(str))
               prods.add(p);
        }
        return prods;
    }

    // Fetching products based on the type of the products
    public List<Product> getProductByType(String type){
        String str = type.toLowerCase();
        List<Product> prods = new ArrayList<>();
        List<Product> prodsList= db.findAll();

        for(Product p : prodsList){
            String typ = p.getType().toLowerCase();
            if(typ.equals(str))
                prods.add(p);
        }
        return prods;
    }

    // Fetching products based on the place
    public List<Product> getProductWithPlace(String plc){
        String str= plc.toLowerCase();
        List<Product> prods = new ArrayList<>();
        List<Product> prodsList= db.findAll();

        for(Product p: prodsList){
            String place = p.getPlace().toLowerCase();
            if(place.contains(str))
                prods.add(p);
        }
        return prods;
    }

    // Fetching products which are currently out of Warranty
    public List<Product> getProductOutOfWarrenty(int year){
        List<Product> prods = new ArrayList<>();
        List<Product> prodsList= db.findAll();
        for(Product p: prodsList){
            if(p.getWarranty()<year)
                prods.add(p);
        }
        return prods;
    }


    // Fetching products based on the text
    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();
        List<Product> prodsList= db.findAll();

        for(Product p : prodsList){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(str) || type.contains(str) || place.contains(str))
                prods.add(p);
        }
        return prods;
    }

    // Fetching all products
    public List<Product> getAllProducts(){
        List<Product> productList= db.findAll();
        return productList;
    }
}
