package bai3.com.bai3.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartEntity {
    private final Map<Long, Integer> cartEntities = new HashMap<>();


    public void addToCart(Long productId) {
        Integer amount = 0;

        if (cartEntities.containsKey(productId)) {
            amount = cartEntities.get(productId);
        }

        cartEntities.put(productId, amount + 1);
        System.out.println("cart entity");
        System.out.println(cartEntities.keySet().size());
    }

    public Map<Long, Integer> getCart() {
        return cartEntities;
    }
}
