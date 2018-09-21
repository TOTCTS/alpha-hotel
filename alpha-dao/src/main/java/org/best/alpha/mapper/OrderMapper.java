package org.best.alpha.mapper;

import org.best.alpha.entity.OrderPo;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-20 19:51
 * @description:
 **/
public interface OrderMapper {

    void put(OrderPo orderPo);

    void update(OrderPo orderPo);

    void deleteById(Long id);

    OrderPo findById(Long id);

    List<OrderPo> getPage(Long startId, Integer pageSize);

    List<OrderPo> getAll();

    List<OrderPo> getOrderByTableId(Integer tableId);

}
