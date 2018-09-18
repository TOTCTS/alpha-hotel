package org.best.alpha.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.best.alpha.entity.CategoryPo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {

    void put(CategoryPo categoryPo);

    void update(CategoryPo categoryPo);

    void remove(Integer id);

    CategoryPo findById(Integer id);

    List<CategoryPo> getAll();

    List<CategoryPo> findByCategoryName(String categoryName);

}
