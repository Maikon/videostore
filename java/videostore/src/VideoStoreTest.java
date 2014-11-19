import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest {


  private static final NewReleaseMovie NEW_RELEASE_MOVIE = new NewReleaseMovie("Interstellar");
  private static final ChildrenMovie CHILDREN_MOVIE = new ChildrenMovie("Winnie the Pooh");
  public static final RegularMovie REGULAR_MOVIE = new RegularMovie("The Matrix");
  private Customer customer;
  private static final int ONE_DAY = 1;
  private static final int TWO_DAYS = 2;
  private static final int THREE_DAYS = 3;
  private static final int FOUR_DAYS = 4;

  @Before
  public void setUp() {
    customer = new Customer("Fred");
  }

  @Test
  public void multipleMoviesStatement() {
    customer.addRental(new Rental(CHILDREN_MOVIE, ONE_DAY));
    customer.addRental(new Rental(NEW_RELEASE_MOVIE, FOUR_DAYS));
    customer.addRental(new Rental(REGULAR_MOVIE, TWO_DAYS));
    assertEquals("Rental Record for Fred\n\t" +
                "Winnie the Pooh\t1.5\n\t" +
                "Interstellar\t12.0\n\t" +
                "The Matrix\t2.0\n" +
                "You owed 15.5\n" +
                "You earned 4 frequent renter points\n", customer.statement());
  }

  @Test
  public void multipleRegularStatement() {
    customer.addRental(new Rental(REGULAR_MOVIE, ONE_DAY));
    customer.addRental(new Rental(new RegularMovie("The Avengers"), TWO_DAYS));
    customer.addRental(new Rental(new RegularMovie("EraserHead"), THREE_DAYS));

    assertEquals("Rental Record for Fred\n\t" +
                 "The Matrix\t2.0\n\t" +
                 "The Avengers\t2.0\n\t" +
                 "EraserHead\t3.5\n" +
                 "You owed 7.5\n" +
                 "You earned 3 frequent renter points\n", customer.statement());
  }
}
