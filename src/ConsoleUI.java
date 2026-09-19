public class ConsoleUI {
    private static Library library;

    public ConsoleUI(Library library){
        this.library = library;

    }
    public static void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Vælg hvad du skal: "));
            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg");
            }
        }
        }
        private static void borrowBook(){
            IO.println("Lån en bog");
            int valgAfBog = Integer.parseInt(IO.readln("Indtast Bog ID: "));
            int medlemsNummer = Integer.parseInt(IO.readln("Indtast Medlemsnummer: "));
            boolean success = library.loanBook(valgAfBog, medlemsNummer);
            if (success){
                IO.println("Du har lånt: " + valgAfBog);

            } else {
                IO.println("Ugyldigt input prøv igen.");
            }
        }
        private static void returnBook(){
            IO.println("Return book");
            int valgAfBog = Integer.parseInt(IO.readln("Indtast Bog ID: "));
            boolean success = library.returnLoan(valgAfBog);
            if (success){
                IO.println("Du har retuneret: " + valgAfBog);
            } else {
                IO.println("Ugyldigt Bog ID");
            }
        }
        private static void showLoans(){
            IO.println("Vis alle loans");
            int medlemsNummer = Integer.parseInt(IO.readln("Indtast Medlem ID: "));
            Member member = library.getMember(medlemsNummer);

            if (member != null){
                IO.println(library.findLoansByMemberId(medlemsNummer));
            } else {
                IO.println("Ugyldigt Medlem ID");
            }
        }

    private static void showMenu() {
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("0. Afslut");
        IO.println();
    }
}
