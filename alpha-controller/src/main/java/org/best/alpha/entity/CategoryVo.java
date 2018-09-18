package org.best.alpha.entity;

import org.best.alpha.base.BaseVo;

public class CategoryVo extends BaseVo {

    private Integer id;

    private String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
