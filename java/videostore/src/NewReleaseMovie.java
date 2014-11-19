public class NewReleaseMovie extends Movie {

  public static final int PRICE_CODE = 1;

  public NewReleaseMovie(String title) {
    super(PRICE_CODE, title);
  }

  @Override
  public double getAmount(int daysRented) {
    double amount = 0.0;
    amount += daysRented * 3;
    return amount;
  }
}
