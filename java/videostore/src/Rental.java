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
    return movie.getAmount(daysRented);
  }

  public int getFrequentPointsForMovie() {
    return movie.getFrequentPoints(daysRented);
  }
}
