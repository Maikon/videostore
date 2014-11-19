public class RegularMovie extends Movie {

  public static final int PRICE_CODE = 0;
  private final double TWO_DAYS = 2.0;
  private final double ONE_AND_HALF_DAY = 1.5;

  public RegularMovie(String title) {
    super(PRICE_CODE, title);
  }

  @Override
  public double getAmount(int daysRented) {
    double amount = TWO_DAYS;
    if (daysRented > TWO_DAYS) {
      amount += (daysRented - TWO_DAYS) * ONE_AND_HALF_DAY;
    }
    return amount;
  }
}
