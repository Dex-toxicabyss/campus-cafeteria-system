import java.util.List;

/**
 * One selected menu item and its quantity in the active order.
 */
public class ItemPesanan {
    private final Minuman minuman;
    private final int jumlah;

    public ItemPesanan(Minuman minuman, int jumlah) {
        if (jumlah < 1) {
            throw new IllegalArgumentException("Jumlah pesanan minimal satu.");
        }
        this.minuman = minuman;
        this.jumlah = jumlah;
    }

    public int getSubtotal() {
        return minuman.getHarga() * jumlah;
    }

    public String tampilkanRingkasan() {
        String detailTopping = "";
        if (minuman instanceof Toppingable) {
            List<String> topping = ((Toppingable) minuman).getTopping();
            if (!topping.isEmpty()) {
                detailTopping = " + " + String.join(", ", topping);
            }
        }
        return String.format("%s%s x%d = Rp%,d", minuman.getNama(), detailTopping, jumlah, getSubtotal());
    }
}
