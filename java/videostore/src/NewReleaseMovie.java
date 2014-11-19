public class NewReleaseMovie extends Movie {


  public NewReleaseMovie(String title) {
    super(title);
  }

  @Override
  public double getAmount(int daysRented) {
    return daysRented * 3;
  }

  @Override
  public int getFrequentPoints(int daysRented) {
    if (daysRented > 1) {
      return 2;
    }
    return 1;
  }
}
