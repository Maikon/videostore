import java.util.Vector;

public class Customer {
  private final Statement statement = new Statement();
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
    return statement.statement(getName(), rentals);
  }
}
