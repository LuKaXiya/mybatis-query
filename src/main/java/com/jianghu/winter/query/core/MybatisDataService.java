package com.jianghu.winter.query.core;

import java.io.Serializable;
import java.util.List;

/**
 * @param <E> - entity (like UserEntity)
 * @param <I> - the type of the identifier (like Long or Integer)
 * @param <Q> - query (like UserQuery)
 * @author daniel.hu
 */
public interface MybatisDataService<E extends Persistable<I>, I extends Serializable, Q extends PageQuery> {

    E get(I id);

    E get(Q query);

    void create(E entity);

    int create(Iterable<E> entities);

    void update(E entity);

    void patch(E entity);

    int patch(E entity, Q query);

    void delete(I id);

    int delete(Q query);

    List<E> query(Q query);

    long count(Q query);

    default PageList<E> page(Q query) {
        return new PageList<>(query(query), count(query));
    }

}
