package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import model.Collection;
import model.Inventory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;


@Configuration

public class SpringMongoConfig {

    @Value("${spring.application.name}")
    private String proAppName;

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String mongoDB;

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {

//        MongoCredential mongoCredential = MongoCredential.createCredential("",mongoDB,"".toCharArray());toCharArray
        ServerAddress address = new ServerAddress(mongoHost, Integer.parseInt(mongoPort));
        MongoClient mongoClient = new MongoClient(address);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient,mongoDB);

        return mongoTemplate;
    }

    public
    List<Collection> mongoTemplate(String name, String price, Collection collection) throws Exception {
        List<Collection> collectionList;
        ServerAddress address = new ServerAddress(mongoHost, Integer.parseInt(mongoPort));
        MongoClient mongoClient = new MongoClient(address);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient,mongoDB);


        Query query = new Query();

        if(name!=null)
            query.addCriteria(Criteria.where("name").is(name));

        if(price != null)
            query.addCriteria(new Criteria().andOperator(Criteria.where("price").is(price)));


        collectionList = mongoTemplate.find(query, Collection.class);

        return collectionList;
    }

}