package org.best.alpha.service;

import org.best.alpha.entity.CategoryPo;
import org.best.alpha.exception.NotFoundException;
import org.best.alpha.util.Assert;
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

        Assert.isNull(categoryPo.getId(), "id of entity updated is null!");

        categoryMapper.update(categoryPo);

    }

    @Override
    public void delete(Integer id) {

        Assert.isNull(id, "id of entity deleted is null!");

        categoryMapper.remove(id);

    }

    @Override
    public CategoryPo findById(Integer id) {

        Assert.isNull(id, "id of entity found is null!");
        CategoryPo categoryPo = categoryMapper.findById(id);
        if (Assert.isNull(categoryPo)) {
            throw new NotFoundException("resource is not exist for id specified");
        }
        return categoryPo;
    }

    @Override
    public List<CategoryPo> getAll() {
        return categoryMapper.getAll();
    }

    @Override
    public List<CategoryPo> findByCategoryName(String categoryName) {

        boolean emptyText = Assert.isEmptyText(categoryName);

        if (emptyText) {
            return new ArrayList<>();
        } else {
            return categoryMapper.findByCategoryName(categoryName);
        }
    }
}
