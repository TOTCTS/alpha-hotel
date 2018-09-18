package org.best.alpha.entity;

public class CategoryVo {

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
