public abstract class Movie {
  protected String title;

  public Movie(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public abstract double getAmount(int daysRented);

  public int getFrequentPoints(int daysRented) {
    return 1;
  }
}
