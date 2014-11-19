import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RentalTest {

  public static final int ONE_DAY_RENTED = 1;
  public static final int THREE_DAYS_RENTED = 3;
  public static final int SIX_DAYS_RENTED = 6;

  @Test
  public void getAmountOwedForRegularMovie() {
    RegularMovie movie = new RegularMovie("Gravity");
    Rental rental = new Rental(movie, ONE_DAY_RENTED);
    assertThat(rental.getAmountForMovie(), is(2.0));
  }

  @Test
  public void getAmountOwedForRegularMovieLongerThanTwoDays() {
    RegularMovie movie = new RegularMovie("Gravity");
    Rental rental = new Rental(movie, THREE_DAYS_RENTED);
    assertThat(rental.getAmountForMovie(), is(3.5));
  }

  @Test
  public void getAmountOwedForNewReleaseMovie() {
    NewReleaseMovie movie = new NewReleaseMovie("Interstellar");
    Rental rental = new Rental(movie, ONE_DAY_RENTED);
    assertThat(rental.getAmountForMovie(), is(3.0));
  }

  @Test
  public void getAmountOwedForChildrenMovie() {
    ChildrenMovie movie = new ChildrenMovie("Winnie the Pooh");
    Rental rental = new Rental(movie, ONE_DAY_RENTED);
    assertThat(rental.getAmountForMovie(), is(1.5));
  }

  @Test
  public void getAmountOwedForChildrenMovieLongerThanThreeDays() {
    ChildrenMovie movie = new ChildrenMovie("Winnie the Pooh");
    Rental rental = new Rental(movie, SIX_DAYS_RENTED);
    assertThat(rental.getAmountForMovie(), is(6.0));
  }
}
