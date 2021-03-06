package com.jianghu.winter.query.core;

import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;

/**
 * general interface
 * All interfaces using @Mapper annotations must extends this
 *
 * @param <E> - entity (like UserEntity)
 * @param <I> - the type of the identifier (Long or Integer)
 * @param <Q> - query (like UserQuery)
 * @author daniel.hu
 * @date 2019/8/27 10:26
 */
public interface IMapper<E extends Persistable<I>, I extends Serializable, Q extends PageQuery> {

    @SelectProvider(type = QueryProvider.class, method = "buildSelect")
    List<E> query(Q query);

    @SelectProvider(type = QueryProvider.class, method = "buildCount")
    long count(Q query);

    @Lang(MapperTableDriver.class)
    @Select("SELECT * FROM @{table} WHERE id = #{id}")
    E get(@Param("id") I id);

    @Lang(MapperTableDriver.class)
    @Delete("DELETE FROM @{table} WHERE id = #{id}")
    void delete(@Param("id") I id);

    /**
     * delete by query condition
     *
     * @param query query
     * @return delete count
     */
    @DeleteProvider(type = CrudProvider.class, method = "buildDelete")
    int deleteByQuery(Q query);

    @InsertProvider(type = CrudProvider.class, method = "buildInsert")
    void insert(E e);

    /**
     * batch insert
     *
     * @param entities entity 集合
     * @return batch insert count
     */
    @InsertProvider(type = CrudProvider.class, method = "buildBatchInsert")
    int batchInsert(@Param("list") Iterable<E> entities);

    /**
     * update all fields, null value will be considered.
     *
     * @param e entity
     */
    @UpdateProvider(type = CrudProvider.class, method = "buildUpdate")
    void update(E e);

    /**
     * Update fields that are not null
     *
     * @param e entity
     */
    @UpdateProvider(type = CrudProvider.class, method = "buildPatch")
    void patch(E e);

    /**
     * Update fields for query condition
     *
     * @param e     entity
     * @param query query
     * @return update count
     */
    @UpdateProvider(type = CrudProvider.class, method = "buildPatchByQuery")
    int patchByQuery(E e, Q query);
}
