package org.taru.lanqiao.model;

public class Category {
    private String categoryId;

    private String categoryName;

    private Integer categoryOrder;

    private Integer categoryStatus;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    public Integer getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Integer categoryStatus) {
        this.categoryStatus = categoryStatus;
    }
}