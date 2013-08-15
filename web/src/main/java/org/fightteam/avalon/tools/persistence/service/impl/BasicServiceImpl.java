package org.fightteam.avalon.tools.persistence.service.impl;

import org.fightteam.avalon.tools.persistence.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * 基本业务逻辑类实现
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:38
 * CRUD与分页、排序
 */
@Transactional(readOnly = true)
public abstract class BasicServiceImpl<T,ID extends Serializable> implements BasicService<T,ID> {
    // 方便继承类使用
    protected PagingAndSortingRepository<T,ID> pagingAndSortingRepository;

    /**
     * 设置方法
     * 主要是设置 pagingAndSortingRepository
     * 否则会产生异常
     */
    @PostConstruct
    public abstract void setUp();

    @Override
    public T findById(ID id) {
        return pagingAndSortingRepository.findOne(id);
    }

    @Override
    public void update(T t) {
        pagingAndSortingRepository.save(t);
    }

    @Override
    public void delete(ID id) {
        pagingAndSortingRepository.delete(id);
    }

    @Override
    public T save(T t) {
        return pagingAndSortingRepository.save(t);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return pagingAndSortingRepository.findAll(pageable);
    }

    @Override
    public Iterable<T> findAll(Sort sort) {
        return pagingAndSortingRepository.findAll(sort);
    }
}
