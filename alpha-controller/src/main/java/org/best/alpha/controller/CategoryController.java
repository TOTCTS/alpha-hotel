package org.best.alpha.controller;

import org.best.alpha.entity.CategoryPo;
import org.best.alpha.entity.CategoryVo;
import org.best.alpha.manager.AssertManager;
import org.best.alpha.response.AppResponse;
import org.best.alpha.service.CategoryService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"category"})
public class CategoryController {

    private final CategoryService categoryService;
    private final DozerBeanMapper dozerBeanMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, DozerBeanMapper dozerBeanMapper) {
        this.categoryService = categoryService;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @RequestMapping(method = {RequestMethod.POST})
    public AppResponse put(@RequestBody CategoryVo categoryVo) {
        AssertManager.isNull(categoryVo,
                "entity parameter of method of controller is not null!");
        CategoryPo categoryPo = dozerBeanMapper.map(categoryVo, CategoryPo.class);
        categoryPo = categoryService.put(categoryPo);
        categoryVo = dozerBeanMapper.map(categoryPo, CategoryVo.class);
        return AppResponse.success(categoryVo);
    }

}
