package com.library.main;

import com.library.books.Book;
import com.library.service.LibraryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n1 Add Book");
            System.out.println("2 View Books");
            System.out.println("3 Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if(choice == 1){

                System.out.print("Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Title: ");
                String title = sc.nextLine();

                System.out.print("Author: ");
                String author = sc.nextLine();

                System.out.print("Copies: ");
                int copies = sc.nextInt();

                Book b = new Book(id,title,author,copies);

                service.addBook(b);

            }

            else if(choice == 2){

                service.viewBooks();

            }

            else if(choice == 3){

                break;

            }

        }

    }
}