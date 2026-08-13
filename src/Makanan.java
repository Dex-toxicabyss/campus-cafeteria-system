/**
 * Food product with a 10% discount when its price is greater than Rp15.000.
 */
public class Makanan extends Produk implements Diskonable {
    private String jenisMenu;

    public Makanan(String nama, double harga, int stok, String jenisMenu) {
        super(nama, harga, stok);
        if (jenisMenu == null || jenisMenu.trim().isEmpty()) {
            throw new DataTidakValidException("Jenis menu makanan tidak boleh kosong.");
        }
        this.jenisMenu = jenisMenu.trim();
    }

    @Override
    public String getKategori() {
        return "Makanan";
    }

    @Override
    public double hitungDiskon() {
        return harga > 15000 ? harga * 0.10 : 0;
    }

    @Override
    public double getHargaSetelahDiskon() {
        return harga - hitungDiskon();
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis    : " + jenisMenu);
        System.out.printf("Diskon   : Rp %,.0f%n", hitungDiskon());
        System.out.printf("Harga setelah diskon : Rp %,.0f%n", getHargaSetelahDiskon());
    }
}
