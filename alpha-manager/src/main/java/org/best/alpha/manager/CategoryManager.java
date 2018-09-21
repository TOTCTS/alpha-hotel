package org.best.alpha.manager;

import org.best.alpha.base.BaseManager;
import org.best.alpha.entity.CategoryPo;
import org.best.alpha.exception.AssertException;
import org.best.alpha.exception.ConstraintViolationException;
import org.best.alpha.mapper.CategoryMapper;
import org.best.alpha.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryManager implements BaseManager<CategoryPo> {

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryManager(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void checkEntity(CategoryPo categoryPo) {
        boolean emptyText = Assert.isEmptyText(categoryPo.getCategoryName());
        if (emptyText) {
            throw new AssertException("category name of categoryPo is not null!");
        }
    }

    public void validateData(CategoryPo categoryPo) {

        List<CategoryPo> categoryPoList = categoryMapper.findByCategoryName(categoryPo.getCategoryName());

        boolean emptyCollection = Assert.isEmptyCollection(categoryPoList);

        if (!emptyCollection) {
            throw new ConstraintViolationException("categoryName of categoryPo is duplicated");
        }

    }

}
