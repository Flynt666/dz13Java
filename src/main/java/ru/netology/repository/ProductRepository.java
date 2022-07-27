package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] product = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[product.length + 1];
        for (int i = 0; i < product.length; i++) {
            tmp[i] = product[i];
        }
        tmp[tmp.length - 1] = item;
        product = tmp;
    }

    public Product[] findAll() {
        return product;
    }

    public void removeById(int id) {
        int length = product.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : product) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        product = tmp;
    }


}




