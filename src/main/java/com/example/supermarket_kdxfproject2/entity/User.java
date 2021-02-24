package com.example.supermarket_kdxfproject2.entity;


public class User {
    private String userName;
    private String passWord;
    private String role;

    public User(String username, String password) {
        this.userName=username;
        this.passWord=password;
        this.role=null;
    }


    public User() {
    }

    public User(String userName, String passWord, String role) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }



    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 设置
     * @param passWord
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * 获取
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "{" + userName + "," + passWord + "," + role + "}";
    }
}
