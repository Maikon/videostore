public class ChildrenMovie extends Movie {

  public static final int PRICE_CODE = 2;

  public ChildrenMovie(String title) {
    super(PRICE_CODE, title);
  }

  @Override
  public double getAmount(int daysRented) {
    return 1.5;
  }
}
