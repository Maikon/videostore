import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RentalTest {

  private static final int ONE_DAY_RENTED = 1;
  private static final int THREE_DAYS_RENTED = 3;
  private static final int SIX_DAYS_RENTED = 6;
  private static final RegularMovie REGULAR_MOVIE = new RegularMovie("Gravity");
  private static final NewReleaseMovie NEW_RELEASE_MOVIE = new NewReleaseMovie("Interstellar");
  private static final ChildrenMovie CHILDREN_MOVIE = new ChildrenMovie("Winnie the Pooh");

  @Test
  public void getAmountOwedForRegularMovie() {
    Rental rental = new Rental(REGULAR_MOVIE, ONE_DAY_RENTED);
    assertThat(rental.getAmount(), is(2.0));
  }

  @Test
  public void getAmountOwedForRegularMovieLongerThanTwoDays() {
    Rental rental = new Rental(REGULAR_MOVIE, THREE_DAYS_RENTED);
    assertThat(rental.getAmount(), is(3.5));
  }

  @Test
  public void getAmountOwedForNewReleaseMovie() {
    Rental rental = new Rental(NEW_RELEASE_MOVIE, ONE_DAY_RENTED);
    assertThat(rental.getAmount(), is(3.0));
  }

  @Test
  public void getAmountOwedForChildrenMovie() {
    Rental rental = new Rental(CHILDREN_MOVIE, ONE_DAY_RENTED);
    assertThat(rental.getAmount(), is(1.5));
  }

  @Test
  public void getAmountOwedForChildrenMovieLongerThanThreeDays() {
    Rental rental = new Rental(CHILDREN_MOVIE, SIX_DAYS_RENTED);
    assertThat(rental.getAmount(), is(6.0));
  }

  @Test
  public void getFrequentPointsForMovie() {
    Rental rentalOne = new Rental(REGULAR_MOVIE, ONE_DAY_RENTED);
    Rental rentalTwo = new Rental(CHILDREN_MOVIE, ONE_DAY_RENTED);
    Rental rentalThree = new Rental(NEW_RELEASE_MOVIE, ONE_DAY_RENTED);

    assertThat(rentalOne.getFrequentPoints(), is(1));
    assertThat(rentalTwo.getFrequentPoints(), is(1));
    assertThat(rentalThree.getFrequentPoints(), is(1));
  }

  @Test
  public void getFrequentPointsForNewReleaseMovieLongerThanThreeDays() {
    Rental rental = new Rental(NEW_RELEASE_MOVIE, SIX_DAYS_RENTED);

    assertThat(rental.getFrequentPoints(), is(2));
  }
}
