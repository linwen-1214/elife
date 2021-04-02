package cn.ylw.evaluation.common.dao;

/**
 * 数据层公共接口
 * @author: ylw
 * @date: 2021年04月02日 10时04分
 * @description:
 */
public interface CommonDao<T,ID> {
    /**
     * 通过Id获取数据
     * @param id 主键
     * @return T 数据实例
     */
    T findById(ID id);

    /**
     * 返回具有给定id的实例是否存在
     * @param id 主键
     * @return
     */
    boolean existsById(ID id);

    /**
     * 保存指定的实例数据
     * @param entity
     * @param <E>
     * @return
     */
    <E extends T> int save(E entity);
    /**
     * 更新指定的实例数据
     * @param entity
     * @param <E>
     * @return
     */
    <E extends T> int update(E entity);

    /**
     * 删除指定id的实体。
     * @param id
     * @return
     */
    int deleteById(ID id);
}
