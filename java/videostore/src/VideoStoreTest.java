import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest {

  private static final int THREE_DAYS = 3;
  private static final int ONE_DAY = 1;
  private static final int TWO_DAYS = 2;

  @Before
  public void setUp() {
    customer = new Customer("Fred");
  }

  @Test
  public void singleNewReleaseStatement() {
    customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), THREE_DAYS));
    assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.statement());
  }

  @Test
  public void dualNewReleaseStatement() {
    customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), THREE_DAYS));
    customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.NEW_RELEASE), THREE_DAYS));
    assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customer.statement());
  }

  @Test
  public void singleChildrensStatement() {
    customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.CHILDRENS), THREE_DAYS));
    assertEquals("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.statement());
  }

  @Test
  public void multipleRegularStatement() {
    customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), ONE_DAY));
    customer.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), TWO_DAYS));
    customer.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), THREE_DAYS));

    assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customer.statement());
  }

  private Customer customer;
}
