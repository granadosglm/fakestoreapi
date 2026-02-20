package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JsonFileGenerator {
    public static Map<String, Object> createProduct() {
        Map<String, Object> product = new HashMap<>();
        product.put("title", "Product-" + UUID.randomUUID());
        product.put("price", (int)(Math.random() * 1000));
        return product;
    }
}
