package org.best.alpha.service;

import org.best.alpha.entity.CategoryPo;
import org.best.alpha.manager.AssertManager;
import org.best.alpha.manager.CategoryManager;
import org.best.alpha.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryManager categoryManager;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryManager categoryManager, CategoryMapper categoryMapper) {
        this.categoryManager = categoryManager;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryPo put(CategoryPo categoryPo) {

        categoryManager.checkEntity(categoryPo);

        categoryMapper.put(categoryPo);

        return categoryPo;

    }

    @Override
    public void update(CategoryPo categoryPo) {

        categoryManager.checkEntity(categoryPo);

        AssertManager.isNull(categoryPo.getId(), "Id of entity updated is not null!");

        categoryMapper.update(categoryPo);

    }

    @Override
    public void delete(Integer id) {

        AssertManager.isNull(id, "Id of entity deleted is not null!");

        categoryMapper.remove(id);

    }

    @Override
    public CategoryPo findById(Integer id) {

        AssertManager.isNull(id, "Id of entity found is not null!");

        return categoryMapper.findById(id);
    }

    @Override
    public List<CategoryPo> getAll() {
        return categoryMapper.getAll();
    }

    @Override
    public List<CategoryPo> findByCategoryName(String categoryName) {

        boolean emptyText = AssertManager.isEmptyText(categoryName);

        if (emptyText) {
            return new ArrayList<>();
        } else {
            return categoryMapper.findByCategoryName(categoryName);
        }
    }
}
