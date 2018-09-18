package org.best.alpha.entity;

public class OrderDetailPo {

    private Long id;

    private Long orderId;

    private Integer foodId;

    private Integer foodCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(Integer foodCount) {
        this.foodCount = foodCount;
    }

    @Override
    public String toString() {
        return "OrderDetailPo{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", foodId=" + foodId +
                ", foodCount=" + foodCount +
                '}';
    }
}
