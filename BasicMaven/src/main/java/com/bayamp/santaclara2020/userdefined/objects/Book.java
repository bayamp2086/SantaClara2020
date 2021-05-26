package com.bayamp.santaclara2020.userdefined.objects;

public class Book {

    private String title;
    private String author;
    private String pageCount;
    private String price;

    /**
     * @param title
     * @param author
     * @param pageCount
     * @param price
     */
    public Book(String title, String author, String pageCount, String price) {

        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.price = price;
    }
    /**
     * Method to get the title of the book
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to get the author of the book
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Method to get the page count of the book
     *
     * @return pageCount
     */
    public String getPageCount() {
        return pageCount;
    }

    /**
     * Method to get the price of the book
     *
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Method to display book details
     *
     * @return title, author, pageCount and price
     */
    public String getString() {
        // TODO Auto-generated method stub
        return "[Title:" +title+ " , Author:"+ author+ ", Page Count:" +pageCount+ " , Price:" +price+ "]";
    }

}
