package dao;

import object.CartFlower;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import object.Flower;


public class ShoppingCartDao {
    private FlowerDao productDao = new FlowerDao();
    private List<CartFlower> myCart = new ArrayList<>();

    public void addFlower(int productId) {
        // Check whether the product is existing in the current cart
        Optional<CartFlower> existProduct = myCart.stream().filter(p -> p.getFlower().getId() == productId).findFirst();
        if (!existProduct.isPresent()) {
            Flower p = productDao.getFlowerById(productId);
            myCart.add(new CartFlower(p, p.getPrice(), 1));
        } else {
            myCart = myCart.stream().map(p -> {
                if (p.getFlower().getId() == productId) {
                    p.setQty(p.getQty() + 1);
                }
                return p;
            }).collect(Collectors.toList());
        }

    }

    public void removeProduct(int productId) {
        myCart = myCart.stream().filter(p -> p.getFlower().getId() != productId).collect(Collectors.toList());
    }

    public void updateQty(int productId, int qty) {
        myCart = myCart.stream().map(p -> {
            if (p.getFlower().getId() == productId) {
                p.setQty(qty);
            }
            return p;
        }).collect(Collectors.toList());
    }

    public List<CartFlower> getMyCart() {
        return myCart;
    }

}
