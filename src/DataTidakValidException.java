/**
 * Unchecked exception for invalid product or transaction data.
 */
public class DataTidakValidException extends RuntimeException {
    public DataTidakValidException(String pesan) {
        super(pesan);
    }
}
