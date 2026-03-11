package com.library.service;

import com.library.books.Book;
import com.library.exception.*;

import java.io.*;
import java.util.*;

public class LibraryService {

    private String fileName = "books.txt";

    public void addBook(Book b) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

            bw.write(b.toFileString());
            bw.newLine();

            bw.close();

            System.out.println("Book added successfully");

        } catch (IOException e) {
            System.out.println("File error");
        }
    }

    public List<Book> readBooks() {

        List<Book> books = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Book b = new Book(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Integer.parseInt(data[3])
                );

                books.add(b);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File read error");
        }

        return books;
    }

    public void viewBooks() {

        List<Book> books = readBooks();

        for (Book b : books) {
            b.displayBook();
        }
    }
}