package org.best.alpha.mapper;

import org.best.alpha.base.BaseTest;
import org.best.alpha.entity.CategoryPo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryMapperTest extends BaseTest {

    @Autowired
    private CategoryMapper categoryMapper;

    private String categoryName = "湘菜";
    private CategoryPo categoryPo;

    @Before
    public void setup(){

        categoryPo = new CategoryPo();
        categoryPo.setCategoryName(categoryName);

    }

    @Test
    public void testPut() {

        categoryMapper.put(categoryPo);

        assert categoryPo.getId() > 0;

        List<CategoryPo> categoryPoList = categoryMapper.findByCategoryName(categoryName);


        assert categoryPoList.size() == 1;
        assert categoryName.equals(categoryPoList.get(0).getCategoryName());

    }

    @Test
    public void testUpdate(){

        categoryMapper.put(categoryPo);

        List<CategoryPo> categoryPoList = categoryMapper.findByCategoryName(categoryName);

        assert categoryPoList.size() == 1;

        categoryPo  = categoryPoList.get(0);

        String categoryNameForUpdate = "粤菜";
        categoryPo.setCategoryName(categoryNameForUpdate);

        categoryMapper.update(categoryPo);

        categoryPoList = categoryMapper.findByCategoryName(categoryNameForUpdate);

        assert categoryPoList.size() == 1;

        assert categoryNameForUpdate.equals(categoryPoList.get(0).getCategoryName());

    }

    @Test
    public void testRemove() {

        categoryMapper.put(categoryPo);

        List<CategoryPo> categoryPoList = categoryMapper.findByCategoryName(categoryPo.getCategoryName());

        assert categoryPoList.size() == 1;

        assert categoryPo.getCategoryName().equals(categoryPoList.get(0).getCategoryName());

        categoryPo = categoryPoList.get(0);

        categoryMapper.remove(categoryPo.getId());

        categoryPoList = categoryMapper.findByCategoryName(categoryPo.getCategoryName());

        assert categoryPoList.size() == 0;

    }

    @Test
    public void testFindById() {

        categoryMapper.put(categoryPo);

        assert categoryPo.getId() > 0;

        CategoryPo categoryPoById = categoryMapper.findById(this.categoryPo.getId());

        assert categoryPoById != null;

        assert categoryPo.getId().equals(categoryPoById.getId());

    }

    @Test
    public void testGetAll() {

        List<CategoryPo> categoryPoList = categoryMapper.getAll();

        categoryMapper.put(categoryPo);

        List<CategoryPo> all = categoryMapper.getAll();

        assert all.size() == categoryPoList.size() + 1;

    }

}
