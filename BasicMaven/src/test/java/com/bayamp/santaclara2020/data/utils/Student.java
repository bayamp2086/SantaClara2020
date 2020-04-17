package com.bayamp.utils;

public class Student {

    private String firstName;
    private String lastName;
    private String userName;
    private String pwd;
    private String id;

    /**
     * @param firstName
     * @param lastName
     * @param userName
     * @param pwd
     */
    public Student(String firstName, String lastName, String userName, String pwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.pwd = pwd;
    }

    public Student(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * @return Method to get the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return Method to get the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return Method to get the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return Method to get the password
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @return Method to get the password
     */
    public String getId() {
        return id;
    }

    /**
     * @param Method to set last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param Method to set password
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @param Method to display student details
     */
    public String getString() {
        return "[FirstName:" +firstName+ " , LastName:"+ lastName+ ", UserName:" +userName+ " , Password:" +pwd+ "]";
    }

    /**
     * @param Method to display student details
     */
    @Override
    public String toString() {
        return "[FirstName: " +firstName+ " , LastName: "+ lastName+ ", Id: " +id+ "]";
    }

}
