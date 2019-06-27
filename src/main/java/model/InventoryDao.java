package model;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


public interface InventoryDao {

    void saveToCollections(Inventory entity);

    void removeFromInventory(Inventory entity);

    void updateToCollections(Inventory entity);

    List<Inventory> find(Map<String, String> map);

}
