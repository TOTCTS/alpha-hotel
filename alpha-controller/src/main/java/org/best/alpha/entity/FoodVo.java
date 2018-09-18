package org.best.alpha.entity;

import org.best.alpha.base.BaseVo;

public class FoodVo extends BaseVo {

    private Integer id;

    private String foodName;

    private Integer categoryId;

    private Double price;

    private Double memberPrice;

    private String introduction;

    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(Double memberPrice) {
        this.memberPrice = memberPrice;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FoodVo{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", memberPrice=" + memberPrice +
                ", introduction='" + introduction + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
