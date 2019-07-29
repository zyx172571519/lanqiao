package org.taru.lanqiao.model;

public class Admin {
    private Integer id;

    private String username;

    private String password;

    private String telphone;

    private String email;

    private String realname;

    public Admin(Integer id, String username, String password, String telphone, String email, String realname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telphone = telphone;
        this.email = email;
        this.realname = realname;
    }

    public Admin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }
}