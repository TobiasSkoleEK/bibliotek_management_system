import java.util.ArrayList;
import java.util.Objects;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public Library(){
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }
    public ArrayList<Book> getBooks(){
        return books;
    }
    public ArrayList<Member> getMembers(){
        return members;
    }
    public ArrayList<Loan> getLoans(){
        return loans;
    }
    public void addBook(Book book){
        if (book != null){
            books.add(book);
        }
    }

    public void addMember(Member member){
        if (member != null){
            members.add(member);
        }
    }
    public void addLoan(Loan loan){
        if (loan != null){
            loans.add(loan);
        }
    }
    public void printBooks(){
        for (Book book : books){
            IO.println(book);
        }
    }
    public void printMembers(){
        for (Member member : members){
         IO.println(member);
        }
    }
    public void printLoans(){
        for (Loan loan : loans){
            IO.println(loan);
        }
    }
    public Book getBook(int bookId){
        for (Book book : books){
            if (book.getId() == bookId){
                return book;
            }
        }
        return null;
    }
    public Member getMember(int memberId){
        for (Member member : members){
            if (member.getMemberNumber() == memberId){
                return member;
            }
        }
        return null;
    }
    public boolean loanBook(int bookId, int memberId){
            Book book = getBook(bookId);
            Member member = getMember(memberId);
            if (book == null || member == null){
                return false;
            }
            Loan newLoan = new Loan(book);
            if (newLoan.loanBook(member)){
                loans.add(newLoan);
                return true;
            }
            return false;
        }
        public boolean returnLoan(int bookId){
            Book book = getBook(bookId);
            if (book == null){
                return false;
            }
            for (int i = 0; i < loans.size(); i++){
                Loan loan = loans.get(i);
                if (loan.getBook() != null && loan.getBook().getId() == bookId && !loan.isAvailable()){
                    loan.returnBook();
                    loans.remove(i);
                    return true;
                }
            }
            return false;
        }
        public ArrayList<Loan> findLoansByMemberId(int memberId){
            ArrayList<Loan> foundLoan = new ArrayList<>();
            Member member = getMember(memberId);
            for (Loan loan : loans){
            if (loan.låntAf != null){
                if (loan.låntAf.equals(member)){
                    foundLoan.add(loan);
                }
            }
            }
            return foundLoan;
        }

    public String toString(){
        String totalMembers = getMembers().toString().replace("[", " ").replace("]", " ");
        String totalBooks = getBooks().toString().replace("[", " ").replace("]", " ");
        String totalLoans = getLoans().toString().replace("[", " ").replace("]", " ");
        return String.format("""
                Members: %s
                %s
                %s""", totalMembers, totalBooks, totalLoans);
    }
}
