package impl;


import java.util.List;
import java.util.Map;


public interface CollectionDao<T> {

    void saveToCollections(T entity);

    void removeFromCollection(T entity);

    void updateToCollections(T entity);

    List find(Map<String, String> map);

}
