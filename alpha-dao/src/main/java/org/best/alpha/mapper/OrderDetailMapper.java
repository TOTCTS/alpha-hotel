package org.best.alpha.mapper;

import org.best.alpha.entity.OrderDetailPo;

/**
 * @author: BG336672
 * @create: 2018-09-20 19:57
 * @description:
 **/
public interface OrderDetailMapper {

    void put(OrderDetailPo detailPo);

    void update(OrderDetailPo orderDetailPo);

    void deleteById(Long id);



}
