import java.util.Vector;

public class Statement {
  private static final int STARTING_AMOUNT = 0;

  public String produce(String name, Vector<Rental> rentals) {
    double totalAmount = STARTING_AMOUNT;
    int frequentRenterPoints = STARTING_AMOUNT;
    String result = getStatementHeader(name);
    for (Rental rental : rentals) {
      double rentalAmount = rental.getAmount();
      frequentRenterPoints += rental.getFrequentPoints();
      result += getStatementBody(rental, rentalAmount);
      totalAmount += rentalAmount;
    }
    result += getStatementFooter(totalAmount, frequentRenterPoints);
    return result;
  }

  private String getStatementFooter(double totalAmount, int frequentRenterPoints) {
    return "You owed " + totalAmount + "\n" + "You earned " + frequentRenterPoints + " frequent renter points\n";
  }

  private String getStatementBody(Rental rental, double rentalAmount) {
    return "\t" + rental.getMovieTitle() + "\t" + rentalAmount + "\n";
  }

  private String getStatementHeader(String name) {
    return "Rental Record for " + name + "\n";
  }
}