package Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.Period;
class Library {
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    public void addBook(Book book) { books.add(book); }
    public void addMember(Member member) { members.add(member); }
    public void borrowBook(Member member, Book book,LocalDate currentDate) {
        System.out.println(member.getName() + " borrowed " + book.getTitle() + ".");
        System.out.println("Borrow Date: "+currentDate);
    }
    public void returnBook(Member member, Book book) {
        books.add(book);
        System.out.println(member.getName() + " returned " + book.getTitle() + ".");

    }
    public void fine_calculator(Member member,Book book,LocalDate ed){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Return Date for "+ book.getTitle()+" :");
        String str=sc.nextLine();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate rd=LocalDate.parse(str,formatter);
        Period period=Period.between(ed,rd);
        if(period.getDays()>0) {
            System.out.println(Math.abs(period.getDays() * 100));
        }
        else{
            System.out.println("No need to pay fine");
        }
    }
    List<Book> getBooks() { return books; }
    List<Member> getMembers() { return members; }
}
class LibraryManage {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new PrintedBook("Atomic_Habits", "James Clear"));
        library.addBook(new EBook("Psychology_Of_Money", "Morgan Housel"));
        library.addMember(new Member(1, "Nihanth"));
        library.addMember(new Member(2, "Naidu"));
        LocalDate currentDate=LocalDate.now();
        LocalDate lastDate=currentDate.plusDays(7);
        library.borrowBook(library.getMembers().get(0), library.getBooks().get(0),currentDate);
        library.returnBook(library.getMembers().get(0), new PrintedBook("Atomic_Habits", "James Clear"));
        library.fine_calculator(library.getMembers().get(0),library.getBooks().get(0),lastDate);
        library.borrowBook(library.getMembers().get(1), library.getBooks().get(1),currentDate);
        library.returnBook(library.getMembers().get(1), new EBook("Psychology_Of_Money", "Morgan Housel"));
        library.fine_calculator(library.getMembers().get(1),library.getBooks().get(1),lastDate);
    }
}