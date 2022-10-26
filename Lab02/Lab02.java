public class Lab02 {
    public static void main(String[] args) {
        int searched_id = 70;

        Book greenMile = new Book("Green Mile", 20);
        Book earthsea = new Book("Earthsea", 6);
        Book hungerGames = new Book("Hunger Games", 3);
        Book perfectImperfection = new Book("Perfect Imperfection", 70);
        Book blackTower = new Book("Black Tower", 16);
        Book tales = new Book("Tales", 10);
        Book vertical = new Book("Vertical", 7);
        Book lotr = new Book("Lord Of The Rings", 9);
        Book hobbit = new Book("Hobbit", 1);
        Book prince = new Book("Prince", 2);
        Book cathedral = new Book("Cathedral", 16);
        Book borderlands = new Book("Borderlands", 5);
        Book americanGods = new Book("American Gods", 21);
        Book moonDust = new Book("", 15);

        moonDust.setId(30);
        moonDust.setName("Moon Dust");
        System.out.println("Number of books at the library: " + Book.getBookCount());

        Library library = new Library();
        library.add(greenMile);
        library.add(earthsea);
        library.add(hungerGames);
        library.add(perfectImperfection);
        library.add(blackTower);
        library.add(tales);
        library.add(vertical);
        library.add(lotr);
        library.add(hobbit);
        library.add(prince);
        library.add(cathedral);
        library.add(borderlands);
        library.add(americanGods);
        library.add(moonDust);

        Book searched = library.searchID(searched_id);
        if(searched == null){
            System.out.println("There is no book with id " + searched_id + " in library");
        } else{
            System.out.println("Book with id " + searched_id + ": " + searched.getName());
        }

        library.printTree();
    }
}
