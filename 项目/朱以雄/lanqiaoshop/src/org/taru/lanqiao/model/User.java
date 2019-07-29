package org.taru.lanqiao.model;

public class User {
    private String userId;

    private String userUserName;

    private String userPassword;

    private String userTelphone;

    private String userAddress;

    private String userShopName;

    private String userComment;

    private Byte userStatus;

    public User(String userId, String userUserName, String userPassword, String userTelphone, String userAddress, String userShopName, String userComment, Byte userStatus) {
        this.userId = userId;
        this.userUserName = userUserName;
        this.userPassword = userPassword;
        this.userTelphone = userTelphone;
        this.userAddress = userAddress;
        this.userShopName = userShopName;
        this.userComment = userComment;
        this.userStatus = userStatus;
    }

    public User() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserUserName() {
        return userUserName;
    }

    public void setUserUserName(String userUserName) {
        this.userUserName = userUserName == null ? null : userUserName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserTelphone() {
        return userTelphone;
    }

    public void setUserTelphone(String userTelphone) {
        this.userTelphone = userTelphone == null ? null : userTelphone.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserShopName() {
        return userShopName;
    }

    public void setUserShopName(String userShopName) {
        this.userShopName = userShopName == null ? null : userShopName.trim();
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment == null ? null : userComment.trim();
    }

    public Byte getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }
}