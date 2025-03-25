package com.softcodemath.ProvisionInventoryManagement.dto;



public class OrderRequest {

    private int customerId;
    private int productId;
    private int quantityOrder;


    public OrderRequest() {
    }

    public OrderRequest(int customerId, int productId, int quantityOrder) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantityOrder = quantityOrder;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }
}
