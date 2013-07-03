package org.fightteam.avalon.tools.persistence.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * 基础业务逻辑类
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:31
 * 包含基本的增删改查与分页
 */
public interface BasicService<T,ID extends Serializable> {
    /**
     * 根据id查找该对象
     * @param id
     * @return
     */
    public T findById(ID id);

    /**
     * 修改该对象
     * @param t
     */
    public void update(T t);

    /**
     * 根据id删除该对象
     * @param id
     */
    public void delete(ID id);

    /**
     * 增加该对象
     * @param t
     * @return
     */
    public T save(T t);

    /**
     * 根据分页信息查找
     * @param pageable
     * @return
     */
    public Page<T> findAll(Pageable pageable);

    /**
     * 根据排序信息查找
     * @param sort
     * @return
     */
    public Iterable<T> findAll(Sort sort);
}
