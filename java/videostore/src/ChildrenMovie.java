public class ChildrenMovie extends Movie {

  public static final int PRICE_CODE = 2;
  private static final double ONE_AND_HALF_DAY = 1.5;
  private static final int THREE_DAYS = 3;

  public ChildrenMovie(String title) {
    super(PRICE_CODE, title);
  }

  @Override
  public double getAmount(int daysRented) {
    double amount = ONE_AND_HALF_DAY;
    if (daysRented > THREE_DAYS) {
      amount += (daysRented - THREE_DAYS) * amount;
    }
    return amount;
  }
}
