package org.best.alpha.entity;

public class CategoryPo {

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
        return "CategoryPo{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
