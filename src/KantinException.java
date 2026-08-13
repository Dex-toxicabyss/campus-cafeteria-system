/**
 * Base checked exception for recoverable cafeteria business errors.
 */
public class KantinException extends Exception {
    public KantinException(String pesan) {
        super(pesan);
    }
}
