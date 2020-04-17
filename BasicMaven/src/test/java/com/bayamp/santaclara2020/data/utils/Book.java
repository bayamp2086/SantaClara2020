package com.bayamp.utils;

public class Book {

    private String title;
    private String author;
    private String pageCount;
    private String price;

    public Book(String title, String author, String pageCount, String price) {

        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPageCount() {
        return pageCount;
    }

    public String getPrice() {
        return price;
    }

    public String getString() {
        // TODO Auto-generated method stub
        return "[Title:" +title+ " , Author:"+ author+ ", Page Count:" +pageCount+ " , Price:" +price+ "]";
    }

}
