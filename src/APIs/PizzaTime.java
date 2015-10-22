package APIs;

/**
 * Created by ZXM on 10/22/15.
 * We have access to 2 external endpoints:
 * 1. /locations/{pizza type}. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
 * Returns a list of strings representing all our locations that produce that type of pizza.
 * .1point3acres缃�
 * Example:
 * /locations/hawaiian : [“TrainStation”, “University”]
 * <p>
 * 2.  /nextPizzaTime/{location}/{pizza type}
 * Returns the earliest time in minutes until that location produces the provided type of pizza. visit 1point3acres.com for more.
 * <p>
 * Example:
 * /nextPizzaTime/TrainStation/hawaiian : 7.1point3acres缃�
 * /nextPizzaTime/University/hawaiian : 11
 * <p>
 * 简单地说, 有以上两个接口, 写第三个:
 * We need to expose an endpoints that returns the earliest time ANY of our locations can produce a pizza type
 * /nextPizzaTime/{pizza type}
 */

/**things to learn
 * use EnumMap
 *
 */

import java.util.*;

/**
 * Created by ZXM on 10/22/15.
 */

enum PizzaType {
    CA, UNIVERSITY, HAWAII;
}

class Location {
    public List<String> findLocations(PizzaType pizzaType) {
        return new ArrayList<>();
    }
}


public class PizzaTime {
    private Map<PizzaType, List<String>> locationsMap;

    public PizzaTime() {
        locationsMap = new EnumMap<>(PizzaType.class);
    }

    public int getNextPizzaTime(PizzaType pizzaType, String location) {
        return 0;
    }
    //without method injection
    public int getEarliestPizzaTime(PizzaType pizzaType) {
        List<String> locations = locationsMap.containsKey(pizzaType) ? locationsMap.get(pizzaType) : new Location().findLocations(pizzaType);
        locationsMap.put(pizzaType, locations);
        int min = Integer.MAX_VALUE;
        for (String location : locations) {
            min = Math.min(min, getNextPizzaTime(pizzaType, location));
        }

        return min;
    }
    //with method injection
    public int getEarliestPizzaTime(PizzaType pizzaType, Location place) {
        List<String> locations = locationsMap.containsKey(pizzaType) ? locationsMap.get(pizzaType) : place.findLocations(pizzaType);
        locationsMap.put(pizzaType, locations);
        int min = Integer.MAX_VALUE;
        for (String location : locations) {
            min = Math.min(min, getNextPizzaTime(pizzaType, location));
        }

        return min;
    }
}

