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
      Rental rental = (Rental) rentals.nextElement();

      double rentalAmount = findAmountForRental(rental);
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

  private double findAmountForRental(Rental rental) {
    double amount = STARTING_AMOUNT;
    switch (rental.getMovie().getPriceCode()) {
      case RegularMovie.PRICE_CODE:
        amount = getAmountForRegularMovie(rental);
        break;
      case NewReleaseMovie.PRICE_CODE:
        amount += rental.getDaysRented() * THREE_DAYS;
        break;
      case ChildrenMovie.PRICE_CODE:
        amount += ONE_AND_HALF_DAY;
        if (rental.getDaysRented() > THREE_DAYS) {
          amount += (rental.getDaysRented() - THREE_DAYS) * ONE_AND_HALF_DAY;
        }
        break;
    }
    return amount;
  }

  private double getAmountForRegularMovie(Rental rental) {
    double amount = STARTING_AMOUNT;
    amount += TWO_DAYS;
    if (rental.getDaysRented() > TWO_DAYS) {
      amount += (rental.getDaysRented() - TWO_DAYS) * ONE_AND_HALF_DAY;
    }
    return amount;
  }
}
