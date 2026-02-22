import dao.BookDAO;
import dao.IssueDAO;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAO();
        IssueDAO issueDAO = new IssueDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    bookDAO.addBook(title, author, qty);
                    break;

                case 2:
                    bookDAO.viewBooks();
                    break;

                case 3:
                    System.out.print("Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Member ID: ");
                    int memberId = sc.nextInt();
                    issueDAO.issueBook(bookId, memberId);
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}