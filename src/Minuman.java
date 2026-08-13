/**
 * Beverage product without a discount contract.
 */
public class Minuman extends Produk {
    private int ukuranMl;

    public Minuman(String nama, double harga, int stok, int ukuranMl) {
        super(nama, harga, stok);
        if (ukuranMl <= 0) {
            throw new DataTidakValidException("Ukuran minuman harus lebih dari nol.");
        }
        this.ukuranMl = ukuranMl;
    }

    @Override
    public String getKategori() {
        return "Minuman";
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran   : " + ukuranMl + " mL");
    }
}
