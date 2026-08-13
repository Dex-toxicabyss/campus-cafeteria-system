import java.util.List;

/**
 * Contract for drinks that can receive optional toppings.
 */
public interface Toppingable {
    void tambahTopping(String topping);

    List<String> getTopping();
}
