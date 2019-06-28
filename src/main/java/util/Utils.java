package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Utils {

    public static String prettyJson(List collections) {
        String jsonString = null;

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        jsonString = gson.toJson(collections);

        return jsonString;
    }
}
