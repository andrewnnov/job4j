package collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {

    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order elementOfOrder: orders) {
            map.put(String.valueOf(elementOfOrder.getNumber()), elementOfOrder);
        }
        return map;
    }
}
