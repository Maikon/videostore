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

  public double getAmountForMovie() {
    return getMovie().getAmount(getDaysRented());
  }

  public int getFrequentPointsForMovie() {
    return getMovie().getFrequentPoints(getDaysRented());
  }

  public String getMovieTitle() {
    return getMovie().getTitle();
  }

  private int getDaysRented() {
    return daysRented;
  }
}
