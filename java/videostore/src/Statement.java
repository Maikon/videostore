import java.util.Vector;

public class Statement {
  private static final int STARTING_AMOUNT = 0;

  public String statement(String name, Vector<Rental> rentals) {
    double totalAmount = STARTING_AMOUNT;
    int frequentRenterPoints = STARTING_AMOUNT;
    String result = "Rental Record for " + name + "\n";

    for (Rental rental : rentals) {
      double rentalAmount = rental.getAmountForMovie();
      frequentRenterPoints += rental.getFrequentPointsForMovie();

      result += "\t" + rental.getMovie().getTitle() + "\t"
        + String.valueOf(rentalAmount) + "\n";
      totalAmount += rentalAmount;
    }

    result += "You owed " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

    return result;
  }
}