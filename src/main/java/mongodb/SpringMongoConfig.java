package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;

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

    @Value("${spring.data.mongodb.collections}")
    private String invCollection;

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {

//        MongoCredential mongoCredential = MongoCredential.createCredential("",mongoDB,"".toCharArray());toCharArray
        ServerAddress address = new ServerAddress(mongoHost, Integer.parseInt(mongoPort));
        MongoClient mongoClient = new MongoClient(address);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient,mongoDB);

        return mongoTemplate;
    }
}