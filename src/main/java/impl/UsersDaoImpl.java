package impl;

import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
@Primary
public class UsersDaoImpl<T> implements CollectionDao<T> {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveToCollections(Object entity) {

    }

    @Override
    public void removeFromCollection(Object entity) {

    }

    @Override
    public void updateToCollections(Object entity) {

    }

    @Override
    public List<Users> find(Map<String, String> map) {

        Query query = new Query();
        int i =0;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(i==0)
                query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
            else {
                query.addCriteria(new Criteria().andOperator(
                        Criteria.where(entry.getKey()).is(entry.getValue())));
            }
            i++;
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        List<Users> userList = mongoTemplate.find(query, Users.class);
        return userList;
    }
}