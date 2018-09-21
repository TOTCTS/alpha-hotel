package org.best.alpha.mapper;

import org.best.alpha.entity.FoodPo;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-20 19:46
 * @description:
 **/
public interface FoodMapper {

    void put(FoodPo foodPo);

    void update(FoodPo foodPo);

    void deleteById(Integer id);

    void deleteByFoodName(String foodName);

    FoodPo findById(Integer id);

    FoodPo findByFoodName(String foodName);

    List<FoodPo> getPage(Integer startId, Integer pageSize);

    List<FoodPo> getAll();

}
