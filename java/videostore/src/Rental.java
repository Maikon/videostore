public class Rental {

  private Movie movie;
  private int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public double getAmount() {
    return getMovie().getAmount(getDaysRented());
  }

  public int getFrequentPoints() {
    return getMovie().getFrequentPoints(getDaysRented());
  }

  public String getMovieTitle() {
    return getMovie().getTitle();
  }

  private int getDaysRented() {
    return daysRented;
  }
}
