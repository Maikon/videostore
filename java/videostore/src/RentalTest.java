import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RentalTest {

  public static final int DAYS_RENTED = 1;

  @Test
  public void getAmountOwedForRegularMovie() {
    RegularMovie movie = new RegularMovie("Gravity");
    Rental rental = new Rental(movie, DAYS_RENTED);
    assertThat(rental.getAmountForMovie(), is(2.0));
  }
}
