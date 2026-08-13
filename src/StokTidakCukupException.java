/**
 * Thrown when an order quantity is greater than the available product stock.
 */
public class StokTidakCukupException extends KantinException {
    public StokTidakCukupException(String pesan) {
        super(pesan);
    }
}
