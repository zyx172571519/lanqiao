package org.taru.lanqiao.model;

public class Customer {
    private String custId;

    private String custName;

    private String custBoss;

    private String custTelphone;

    private String custType;

    private String custAddress;

    private String custAreas;

    private Integer custWeight;

    private Byte custDay;

    private String custAdmin;

    private String custAdminOther;

    private String custSign;

    private String custSignOne;

    private String custSignTwo;

    private String custSignThree;

    private String custSignFourth;

    private String custStatus;

    public Customer(String custId, String custName, String custBoss, String custTelphone, String custType, String custAddress, String custAreas, Integer custWeight, Byte custDay, String custAdmin, String custAdminOther, String custSign, String custSignOne, String custSignTwo, String custSignThree, String custSignFourth, String custStatus) {
        this.custId = custId;
        this.custName = custName;
        this.custBoss = custBoss;
        this.custTelphone = custTelphone;
        this.custType = custType;
        this.custAddress = custAddress;
        this.custAreas = custAreas;
        this.custWeight = custWeight;
        this.custDay = custDay;
        this.custAdmin = custAdmin;
        this.custAdminOther = custAdminOther;
        this.custSign = custSign;
        this.custSignOne = custSignOne;
        this.custSignTwo = custSignTwo;
        this.custSignThree = custSignThree;
        this.custSignFourth = custSignFourth;
        this.custStatus = custStatus;
    }

    public Customer() {
        super();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustBoss() {
        return custBoss;
    }

    public void setCustBoss(String custBoss) {
        this.custBoss = custBoss == null ? null : custBoss.trim();
    }

    public String getCustTelphone() {
        return custTelphone;
    }

    public void setCustTelphone(String custTelphone) {
        this.custTelphone = custTelphone == null ? null : custTelphone.trim();
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType == null ? null : custType.trim();
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress == null ? null : custAddress.trim();
    }

    public String getCustAreas() {
        return custAreas;
    }

    public void setCustAreas(String custAreas) {
        this.custAreas = custAreas == null ? null : custAreas.trim();
    }

    public Integer getCustWeight() {
        return custWeight;
    }

    public void setCustWeight(Integer custWeight) {
        this.custWeight = custWeight;
    }

    public Byte getCustDay() {
        return custDay;
    }

    public void setCustDay(Byte custDay) {
        this.custDay = custDay;
    }

    public String getCustAdmin() {
        return custAdmin;
    }

    public void setCustAdmin(String custAdmin) {
        this.custAdmin = custAdmin == null ? null : custAdmin.trim();
    }

    public String getCustAdminOther() {
        return custAdminOther;
    }

    public void setCustAdminOther(String custAdminOther) {
        this.custAdminOther = custAdminOther == null ? null : custAdminOther.trim();
    }

    public String getCustSign() {
        return custSign;
    }

    public void setCustSign(String custSign) {
        this.custSign = custSign == null ? null : custSign.trim();
    }

    public String getCustSignOne() {
        return custSignOne;
    }

    public void setCustSignOne(String custSignOne) {
        this.custSignOne = custSignOne == null ? null : custSignOne.trim();
    }

    public String getCustSignTwo() {
        return custSignTwo;
    }

    public void setCustSignTwo(String custSignTwo) {
        this.custSignTwo = custSignTwo == null ? null : custSignTwo.trim();
    }

    public String getCustSignThree() {
        return custSignThree;
    }

    public void setCustSignThree(String custSignThree) {
        this.custSignThree = custSignThree == null ? null : custSignThree.trim();
    }

    public String getCustSignFourth() {
        return custSignFourth;
    }

    public void setCustSignFourth(String custSignFourth) {
        this.custSignFourth = custSignFourth == null ? null : custSignFourth.trim();
    }

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus == null ? null : custStatus.trim();
    }
}