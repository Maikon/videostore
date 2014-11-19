public class NewReleaseMovie extends Movie {

  public static final int PRICE_CODE = 1;

  public NewReleaseMovie(String title) {
    super(PRICE_CODE, title);
  }

  @Override
  public double getAmount(int daysRented) {
    return daysRented * 3;
  }
}
