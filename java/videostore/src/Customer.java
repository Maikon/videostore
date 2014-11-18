import java.util.Vector;
import java.util.Enumeration;

public class Customer {
  private static final int STARTING_AMOUNT = 0;
  private static final int TWO_DAYS = 2;
  private static final int THREE_DAYS = 3;
  private static final double ONE_AND_HALF_DAY = 1.5;
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
      double thisAmount = STARTING_AMOUNT;
      Rental each = (Rental) rentals.nextElement();

      // determines the amount for each line
      switch (each.getMovie().getPriceCode()) {
        case Movie.REGULAR:
          thisAmount += TWO_DAYS;
          if (each.getDaysRented() > TWO_DAYS)
            thisAmount += (each.getDaysRented() - TWO_DAYS) * ONE_AND_HALF_DAY;
          break;
        case Movie.NEW_RELEASE:
          thisAmount += each.getDaysRented() * THREE_DAYS;
          break;
        case Movie.CHILDRENS:
          thisAmount += ONE_AND_HALF_DAY;
          if (each.getDaysRented() > THREE_DAYS)
            thisAmount += (each.getDaysRented() - THREE_DAYS) * ONE_AND_HALF_DAY;
          break;
      }

      frequentRenterPoints++;

      if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE
        && each.getDaysRented() > ONE_DAY)
        frequentRenterPoints++;

      result += "\t" + each.getMovie().getTitle() + "\t"
        + String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;

    }

    result += "You owed " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";


    return result;
  }
}
