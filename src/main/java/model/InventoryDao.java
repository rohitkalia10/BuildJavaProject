package model;

import java.util.List;

import org.springframework.stereotype.Component;
import  model.Inventory;


@Component
public interface InventoryDao {

    void saveInventory(Inventory entity);

    void removeInventory(Long id);

    void updateInventory(Inventory entity);

    List<Inventory> findInventoryByName(String name);
    
    List<Inventory> findInventoryByPrice(Double name);
	
}
