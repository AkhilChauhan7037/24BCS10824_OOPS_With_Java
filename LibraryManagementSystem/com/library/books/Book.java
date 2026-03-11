package com.library.books;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private int availableCopies;

    public Book(int bookId, String title, String author, int availableCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public int getBookId() {
        return bookId;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int copies) {
        this.availableCopies = copies;
    }

    public void displayBook() {
        System.out.println(bookId + " | " + title + " | " + author + " | Copies: " + availableCopies);
    }

    public String toFileString() {
        return bookId + "," + title + "," + author + "," + availableCopies;
    }
}