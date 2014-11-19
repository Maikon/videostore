import java.util.Vector;

public class Statement {
  private static final int STARTING_AMOUNT = 0;

  public String statement(String name, Vector<Rental> rentals) {
    double totalAmount = STARTING_AMOUNT;
    int frequentRenterPoints = STARTING_AMOUNT;
    String result = getStatementHeader(name);

    for (Rental rental : rentals) {
      double rentalAmount = rental.getAmountForMovie();
      frequentRenterPoints += rental.getFrequentPointsForMovie();

      result = getStatementBody(result, rental, rentalAmount);
      totalAmount += rentalAmount;
    }
    return getStatementFooter(totalAmount, frequentRenterPoints, result);
  }

  private String getStatementFooter(double totalAmount, int frequentRenterPoints, String result) {
    result += "You owed " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
    return result;
  }

  private String getStatementBody(String result, Rental rental, double rentalAmount) {
    result += "\t" + rental.getMovieTitle() + "\t"
      + String.valueOf(rentalAmount) + "\n";
    return result;
  }

  private String getStatementHeader(String name) {
    return "Rental Record for " + name + "\n";
  }
}