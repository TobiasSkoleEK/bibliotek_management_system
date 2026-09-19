import java.time.LocalDate;
public class Loan {
    Member låntAf;
    LocalDate borrowedDate;
    final Book loaned;

    public Loan(Book loaned){
        this.loaned = loaned;
    }
    public boolean loanBook(Member member) {
        if (isAvailable()) {
            this.låntAf = member;
            borrowedDate = LocalDate.now();
            return true;
        }
        return false;

    }
    public boolean returnBook() {
        if (!isAvailable()) {
            this.låntAf = null;
            borrowedDate = null;
            return true;

        }
        return false;
    }

    public boolean isAvailable(){
        return låntAf == null;
    }

    public LocalDate getDueDate(){
        if (borrowedDate != null) {
            return borrowedDate.plusDays(14);
        }
        return null;
    }
    public boolean isOverdue(){
        if (borrowedDate == null){
            return false;
        }
        return LocalDate.now().isAfter(getDueDate());
    }
    public Book getBook(){
        return this.loaned;
    }
    public String toString(){
        String status = isAvailable() ? "På hylden" : "Udlånt";
        String låner = låntAf == null ? " " : låntAf.name;
        String returnDate = borrowedDate == null ? " " : getDueDate().toString();
        String overdue = !isOverdue() ? " " : "Frist er overskredet";
        return String.format("""
                Tilgænglig: %s
                Afleveringsfrist: %s
                Udlånt: %s
                %s""", status, returnDate, låner, overdue);
    }
}
