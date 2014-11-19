import java.util.Vector;
import java.util.Enumeration;

public class Customer {
  private static final int STARTING_AMOUNT = 0;
  private static final int ONE_DAY = 1;
  private String name;
  private Vector<Rental> rentals = new Vector<Rental>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental rental) {
    rentals.addElement(rental);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    double totalAmount = STARTING_AMOUNT;
    int frequentRenterPoints = STARTING_AMOUNT;
    Enumeration rentals = this.rentals.elements();
    String result = "Rental Record for " + getName() + "\n";

    while (rentals.hasMoreElements()) {
      Rental rental = (Rental) rentals.nextElement();

      double rentalAmount = rental.getAmountForMovie();
      frequentRenterPoints++;

      if (rental.getMovie().getPriceCode() == NewReleaseMovie.PRICE_CODE
        && rental.getDaysRented() > ONE_DAY) {
        frequentRenterPoints++;
      }

      result += "\t" + rental.getMovie().getTitle() + "\t"
        + String.valueOf(rentalAmount) + "\n";
      totalAmount += rentalAmount;

    }

    result += "You owed " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

    return result;
  }
}
