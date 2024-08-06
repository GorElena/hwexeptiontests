import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.AlreadyExistsException;
import ru.netology.Product;

class AlreadyExistsExceptionTest {

    @Test
    public void shouldRemove() {
        Product product1 = new Product(25, "Пуховик", 65_000);
        Product product2 = new Product(26, "Перчатки", 1000);
        Product product3 = new Product(27, "Сапоги", 20_000);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.remove(27);
        Product[] expected = {product1, product2};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addByIdThrowException() {
        Product product1 = new Product(25, "Пуховик", 65_000);
        Product product2 = new Product(26, "Перчатки", 1000);
        Product product3 = new Product(26, "Сапоги", 20_000);

        ShopRepository shop = new ShopRepository();
        shop.add(product1);
        shop.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shop.add(product3);
        });
    }
}
