package com.bayamp.santaclara2020.data.utils;

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

    /**
     * @param firstName
     * @param lastName
     * @param id
     */
    public Student(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * Method to get the firstName
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method to get the lastName
     *
     * @return  lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method to get the user name
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Method to get the password
     *
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Method to get the Id
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Method to set last name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method to set Password
     *
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * Method to display student details
     *
     * @return  firstname, lastname, username and password
     */
    public String getString() {
        return "[FirstName:" +firstName+ " , LastName:"+ lastName+ ", UserName:" +userName+ " , Password:" +pwd+ "]";
    }

    /**
     * Method to display student details
     *
     * @return firstname, lastname and id
     */
    @Override
    public String toString() {
        return "[FirstName: " +firstName+ " , LastName: "+ lastName+ ", Id: " +id+ "]";
    }

}
