package hosi.procure2pay.model.enums;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;


public enum ItemAvailability {
    IN_STOCK(1, "In Stock"),
    OUT_OF_STOCK(2, "Out of Stock");

    private Integer id;
    private String name;

    private static Map<Integer, ItemAvailability> itemAvailabilityMap;
    static {
        initAvailabilityMap();
    }

    ItemAvailability(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private static void initAvailabilityMap() {
        itemAvailabilityMap = new HashMap<Integer, ItemAvailability>();
        for (ItemAvailability availability : values()) {
            itemAvailabilityMap.put(availability.id, availability);
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}