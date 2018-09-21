package org.best.alpha.controller;

import org.best.alpha.entity.CategoryPo;
import org.best.alpha.entity.CategoryVo;
import org.best.alpha.response.AppResponse;
import org.best.alpha.service.CategoryService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = {"category"},
        consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class CategoryController {

    private final CategoryService categoryService;
    private final DozerBeanMapper dozerBeanMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, DozerBeanMapper dozerBeanMapper) {
        this.categoryService = categoryService;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @RequestMapping(method = {RequestMethod.PUT})
    public AppResponse put(@RequestBody CategoryVo categoryVo) {
        CategoryPo categoryPo = dozerBeanMapper.map(categoryVo, CategoryPo.class);
        categoryPo = categoryService.put(categoryPo);
        categoryVo = dozerBeanMapper.map(categoryPo, CategoryVo.class);
        return AppResponse.success(categoryVo);
    }

    @RequestMapping(method = {RequestMethod.POST})
    public AppResponse update(@RequestBody CategoryVo categoryVo) {
        CategoryPo categoryPo = dozerBeanMapper.map(categoryVo, CategoryPo.class);
        categoryService.update(categoryPo);
        categoryPo = categoryService.findById(categoryPo.getId());
        categoryVo = dozerBeanMapper.map(categoryPo, CategoryVo.class);
        return AppResponse.success(categoryVo);
    }

    @RequestMapping(value = {"{id}"}, method = {RequestMethod.DELETE})
    public AppResponse remove(@PathVariable Integer id) {
        categoryService.delete(id);
        return AppResponse.success();
    }

    @RequestMapping(value = {"{id}"}, method = {RequestMethod.GET})
    public AppResponse findById(@PathVariable Integer id) {
        CategoryPo categoryPo = categoryService.findById(id);
        CategoryVo categoryVo = dozerBeanMapper.map(categoryPo, CategoryVo.class);
        return AppResponse.success(categoryVo);
    }

    @RequestMapping(value = {"list"}, method = {RequestMethod.GET})
    public AppResponse list() {
        List<CategoryPo> categoryPoList = categoryService.getAll();
        List<CategoryVo> categoryVoList = categoryPoList.stream()
                .map(po -> dozerBeanMapper.map(po, CategoryVo.class))
                .collect(Collectors.toList());
        return AppResponse.success(categoryVoList);
    }

    @RequestMapping(value = {"list/{categoryName}"}, method = {RequestMethod.GET})
    public AppResponse findByCategoryName(@PathVariable String categoryName) {
        List<CategoryPo> categoryPoList = categoryService.findByCategoryName(categoryName);
        return AppResponse.success(categoryPoList);
    }


}
