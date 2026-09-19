void main() {

    Library library = new Library();
    Book book1 = new Book("Allan B. Downey", "Think Java", "9781492072508", 1);
    Book book2 = new Book("Alexandre Dumas","The Count Of Monte Cristo", "483684629347", 2);
    Member member1 = new Member("Thorkild Hansen", 111);
    Member member2 = new Member("Mathias Jensen", 666);
    Loan loan1 = new Loan(book1);
    Loan loan2 = new Loan(book2);
    library.addMember(member1);
    library.addBook(book1);
    library.addMember(member2);
    library.addBook(book2);
    ConsoleUI consoleUI = new ConsoleUI(library);
    ConsoleUI.run();
    //IO.println(library.loanBook(1, 111));
    //IO.println(library.loanBook(2, 111));
    //IO.println(library.findLoansByMemberId(111));
    //IO.println(library.returnLoan(1));
    //Member foundMember = library.getMember(111);
    //IO.println(foundMember);
//    Book foundBook = library.getBook(1);
//    IO.println(foundBook);
//    Book notFoundBook = library.getBook(11);
//    IO.println(notFoundBook);

//    loan1.loanBook(member1);
//    library.addMember(member1);
//    library.addLoan(loan1);
//    IO.println(library);
//
//    loan2.loanBook(member2);
//    library.addMember(member2);
//    library.addBook(book2);
//    IO.println(library);
//
//
//    library.printMembers();
//    library.printBooks();










}

