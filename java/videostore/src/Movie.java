public class Movie {
  protected String title;
  protected int priceCode;

  public Movie(int priceCode, String title) {
    this.priceCode = priceCode;
    this.title = title;
  }

  public int getPriceCode() {
    return priceCode;
  }

  public String getTitle() {
    return title;
  }

  public double getAmount(int daysRented) {
    return 0.0;
  }
}
