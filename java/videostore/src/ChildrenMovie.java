public class ChildrenMovie extends Movie {

  public ChildrenMovie(String title) {
    super(title);
  }

  @Override
  public double getAmount(int daysRented) {
    if (daysRented > 3) {
      return 1.5 + (daysRented - 3) * 1.5;
    }
    return 1.5;
  }
}
