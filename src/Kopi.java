import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kopi extends Minuman implements Toppingable {
    private final List<String> topping = new ArrayList<String>();

    public Kopi(int id, String nama, int harga) {
        super(id, nama, harga);
    }

    @Override
    public String getRasa() {
        return "pahit dan bold";
    }

    @Override
    public void tambahTopping(String namaTopping) {
        if (namaTopping != null && !namaTopping.trim().isEmpty()) {
            topping.add(namaTopping.trim());
        }
    }

    @Override
    public List<String> getTopping() {
        return Collections.unmodifiableList(topping);
    }
}
