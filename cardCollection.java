import java.util.*;

class Card {
    String symbol;
    String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[Symbol: " + symbol + ", Value: " + value + "]";
    }
}

public class CardCollection {
    static Collection<Card> cards = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCard Management System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    findCardsBySymbol();
                    break;
                case 3:
                    displayCards();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addCard() {
        System.out.print("Enter Card Symbol: ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Card Value: ");
        String value = scanner.nextLine();

        cards.add(new Card(symbol, value));
        System.out.println("Card added successfully.");
    }

    static void findCardsBySymbol() {
        System.out.print("Enter Symbol to search: ");
        String symbol = scanner.nextLine();
        boolean found = false;

        for (Card card : cards) {
            if (card.symbol.equalsIgnoreCase(symbol)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found with the given symbol.");
        }
    }

    static void displayCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards to display.");
            return;
        }
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
