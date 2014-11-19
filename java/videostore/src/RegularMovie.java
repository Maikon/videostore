public class RegularMovie extends Movie {

  public static final int PRICE_CODE = 0;

  public RegularMovie(String title) {
    super(PRICE_CODE, title);
  }

  @Override
  public double getAmount() {
    return 2.0;
  }
}
