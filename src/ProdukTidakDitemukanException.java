/**
 * Thrown when a requested product is not present in a transaction.
 */
public class ProdukTidakDitemukanException extends KantinException {
    public ProdukTidakDitemukanException(String pesan) {
        super(pesan);
    }
}
