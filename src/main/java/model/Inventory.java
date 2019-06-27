package model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory")
public class Inventory {

    @Id
    public ObjectId _id;

    public String name;
    
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Inventory() {

    }
    public Inventory(ObjectId _id, String name, double price) {
        this._id = _id;
        this.name = name;
        this.price = price;
    }
}
