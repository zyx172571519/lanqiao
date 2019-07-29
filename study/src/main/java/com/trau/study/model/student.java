package com.trau.study.model;

public class student {
    public String newId;
    public String newTitle;
    public String newImg;
    public String newPinlun;
    public String Status;

    public String getNewImg() {
        return newImg;
    }

    public void setNewImg(String newImg) {
        this.newImg = newImg;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewPinlun() {
        return newPinlun;
    }

    public void setNewPinlun(String newPinlun) {
        this.newPinlun = newPinlun;
    }

    @Override
    public String toString() {
        return "student{" +
                "newId='" + newId + '\'' +
                ", newTitle='" + newTitle + '\'' +
                ", newImg='" + newImg + '\'' +
                ", newPinlun='" + newPinlun + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
