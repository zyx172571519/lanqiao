package org.taru.lanqiao.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderList {
    private String orderId;

    private String orderUserId;

    private Date orderDateTime;

    private Byte orderIsSend;

    private Byte orderIsValid;

    private BigDecimal orderTotalPrice;

    private Byte orderStatus;

    private String orderComment;

    public OrderList(String orderId, String orderUserId, Date orderDateTime, Byte orderIsSend, Byte orderIsValid, BigDecimal orderTotalPrice, Byte orderStatus, String orderComment) {
        this.orderId = orderId;
        this.orderUserId = orderUserId;
        this.orderDateTime = orderDateTime;
        this.orderIsSend = orderIsSend;
        this.orderIsValid = orderIsValid;
        this.orderTotalPrice = orderTotalPrice;
        this.orderStatus = orderStatus;
        this.orderComment = orderComment;
    }

    public OrderList() {
        super();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId == null ? null : orderUserId.trim();
    }

    public Date getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Date orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Byte getOrderIsSend() {
        return orderIsSend;
    }

    public void setOrderIsSend(Byte orderIsSend) {
        this.orderIsSend = orderIsSend;
    }

    public Byte getOrderIsValid() {
        return orderIsValid;
    }

    public void setOrderIsValid(Byte orderIsValid) {
        this.orderIsValid = orderIsValid;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment == null ? null : orderComment.trim();
    }
}