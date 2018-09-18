package org.best.alpha.service;

import org.best.alpha.entity.CategoryPo;

import java.util.List;

public interface CategoryService {

    CategoryPo put(CategoryPo categoryPo);

    void update(CategoryPo categoryPo);

    void delete(Integer id);

    CategoryPo findById(Integer id);

    List<CategoryPo> getAll();

    List<CategoryPo> findByCategoryName(String categoryName);

}
