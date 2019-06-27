package impl;

import model.InventoryDao;
import model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component

public class InventoryDaoImpl implements InventoryDao {


    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public void saveToCollections(Inventory entity) {

    }

    @Override
    public void removeFromInventory(Inventory entity) {

    }

    @Override
    public void updateToCollections(Inventory entity) {

    }

    @Override
    public List<Inventory> find(Map<String, String> map) {

        Query query = new Query();
        int i =0;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(i==0)
                query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
            else {
                query.addCriteria(new Criteria().andOperator(
                        Criteria.where(entry.getKey()).is(Double.parseDouble(entry.getValue()))));
            }
            i++;
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        List<Inventory> inventoryList = mongoTemplate.find(query, Inventory.class);


        return inventoryList;
    }
}
