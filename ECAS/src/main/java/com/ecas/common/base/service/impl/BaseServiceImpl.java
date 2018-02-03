package com.ecas.common.base.service.impl;




import com.ecas.common.base.manager.BaseManager;
import com.ecas.common.base.service.BaseService;

import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date 18-1-31 上午12:49
 */
public  class BaseServiceImpl<M extends BaseManager<T>,T> implements BaseService<T> {


    public M manager;

    @Override
    public void save(T t) {
       manager.save(t);
    }

    @Override
    public void saveBatch(List<T> list) {
        manager.saveBatch(list);
    }

    @Override
    public void removeById(Long id) {
        manager.removeById(id);
    }

    @Override
    public void removeBatch(List<Long> idList) {
       manager.removeBatch(idList);
    }

    @Override
    public void removeByParam(T t) {
        manager.removeByParam(t);
    }

    @Override
    public void modify(T t) {
        manager.modify(t);
    }

    @Override
    public void modifyBatch(List<T> list) {
       manager.modifyBatch(list);
    }

    @Override
    public T getById(Long id) {
        return manager.getById(id);
    }

    @Override
    public List<T> listByObject(T t) {
        return manager.listByObject(t);
    }

    @Override
    public List<T> listByIds(List<Long> ids) {
        return manager.listByIds(ids);
    }

    @Override
    public List<T> listPage(T t, Integer size, Integer offset) {
        return manager.listPage(t,size,offset);
    }

    @Override
    public Integer countParam(T t) {
        return manager.countParam(t);
    }
}
