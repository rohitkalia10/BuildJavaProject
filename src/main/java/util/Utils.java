package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Inventory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Utils {

    public static String prettyJson(List<Inventory> collections) {
        String jsonString = null;

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        jsonString = gson.toJson(collections);

        return jsonString;
    }
}
