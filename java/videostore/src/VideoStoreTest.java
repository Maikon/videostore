import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest {


  public static final int FOUR_DAYS = 4;
  private Customer customer;
  private static final int THREE_DAYS = 3;
  private static final int ONE_DAY = 1;
  private static final int TWO_DAYS = 2;

  @Before
  public void setUp() {
    customer = new Customer("Fred");
  }

  @Test
  public void singleNewReleaseStatement() {
    customer.addRental(new Rental(new RegularMovie("The Cell", NewReleaseMovie.PRICE_CODE), THREE_DAYS));
    assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.statement());
  }

  @Test
  public void dualNewReleaseStatement() {
    customer.addRental(new Rental(new RegularMovie("The Cell", NewReleaseMovie.PRICE_CODE), THREE_DAYS));
    customer.addRental(new Rental(new RegularMovie("The Tiger Movie", NewReleaseMovie.PRICE_CODE), THREE_DAYS));
    assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tiger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customer.statement());
  }

  @Test
  public void singleChildrenStatement() {
    customer.addRental(new Rental(new RegularMovie("The Tiger Movie", ChildrenMovie.PRICE_CODE), THREE_DAYS));
    assertEquals("Rental Record for Fred\n\tThe Tiger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.statement());
  }

  @Test
  public void childrenMovieOverThreeDaysRental() {
    customer.addRental(new Rental(new RegularMovie("Lion King", ChildrenMovie.PRICE_CODE), FOUR_DAYS));
    assertEquals("Rental Record for Fred\n\tLion King\t3.0\nYou owed 3.0\nYou earned 1 frequent renter points\n", customer.statement());
  }

  @Test
  public void multipleRegularStatement() {
    customer.addRental(new Rental(new RegularMovie("Plan 9 from Outer Space", RegularMovie.PRICE_CODE), ONE_DAY));
    customer.addRental(new Rental(new RegularMovie("8 1/2", RegularMovie.PRICE_CODE), TWO_DAYS));
    customer.addRental(new Rental(new RegularMovie("EraserHead", RegularMovie.PRICE_CODE), THREE_DAYS));

    assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserHead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customer.statement());
  }
}
