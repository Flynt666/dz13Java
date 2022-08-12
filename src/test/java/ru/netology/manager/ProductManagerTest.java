package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "100 кулинарных рецептов", 135, "Евгений Пашот");
    Product book2 = new Book(2, "Незнайкана луне", 455, "Николай Носов");
    Product smartphone1 = new Smartphone(3, "IPhone13", 150_000, "Apple");
    Product smartphone2 = new Smartphone(4, "Galaxy", 34_000, "Samsung");
    Product smartphone3 = new Smartphone(5, "Mi A1", 10_000, "Xiaomi");

    @BeforeEach
    public void shouldAddProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

    }

    @Test
    public void shouldFindByName () {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Незнайкана луне");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Nokia");

        Assertions.assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldFindByNameOneOfSomeProducts() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("IPhone13");

        Assertions.assertArrayEquals(expected, actual);
    }

}