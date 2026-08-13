import java.util.ArrayList;
import java.util.Locale;

/**
 * Stores one customer's order using parallel product and quantity lists.
 */
public class Transaksi {
    private String namaPelanggan;
    private ArrayList<Produk> daftarProduk;
    private ArrayList<Integer> jumlahPesan;

    public Transaksi(String namaPelanggan) {
        if (namaPelanggan == null || namaPelanggan.trim().isEmpty()) {
            throw new DataTidakValidException("Nama pelanggan tidak boleh kosong.");
        }
        this.namaPelanggan = namaPelanggan.trim();
        this.daftarProduk = new ArrayList<Produk>();
        this.jumlahPesan = new ArrayList<Integer>();
    }

    public void tambahProduk(Produk produk, int jumlah) throws StokTidakCukupException {
        if (produk == null) {
            throw new DataTidakValidException("Produk tidak boleh null.");
        }

        produk.kurangiStok(jumlah);
        daftarProduk.add(produk);
        jumlahPesan.add(jumlah);
    }

    public Produk cariProduk(String nama) throws ProdukTidakDitemukanException {
        for (Produk produk : daftarProduk) {
            if (produk.getNama().equalsIgnoreCase(nama)) {
                return produk;
            }
        }
        throw new ProdukTidakDitemukanException("Produk '" + nama + "' tidak ditemukan pada transaksi.");
    }

    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < daftarProduk.size(); i++) {
            Produk produk = daftarProduk.get(i);
            int jumlah = jumlahPesan.get(i);
            double hargaSatuan = produk instanceof Makanan
                ? ((Makanan) produk).getHargaSetelahDiskon()
                : produk.getHarga();
            total += hargaSatuan * jumlah;
        }
        return total;
    }

    public void cetakStruk() {
        System.out.println("========================================");
        System.out.println("KANTIN KAMPUS SEJAHTERA");
        System.out.println("========================================");
        System.out.println("Pelanggan : " + namaPelanggan);
        System.out.println("----------------------------------------");
        System.out.printf("%-4s %-22s %3s %12s%n", "No", "Produk", "Qty", "Harga");
        System.out.println("----------------------------------------");

        for (int i = 0; i < daftarProduk.size(); i++) {
            Produk produk = daftarProduk.get(i);
            int jumlah = jumlahPesan.get(i);
            boolean dapatDiskon = produk instanceof Makanan && ((Makanan) produk).hitungDiskon() > 0;
            double hargaSatuan = produk instanceof Makanan
                ? ((Makanan) produk).getHargaSetelahDiskon()
                : produk.getHarga();
            String tandaDiskon = dapatDiskon ? " *" : "";
            String totalBaris = "Rp " + formatRupiah(hargaSatuan * jumlah) + tandaDiskon;

            System.out.printf("%-4d %-22s %3d %12s%n", i + 1, produk.getNama(), jumlah, totalBaris);
        }

        System.out.println("----------------------------------------");
        System.out.println("* harga setelah diskon");
        System.out.println("TOTAL : Rp " + formatRupiah(hitungTotal()));
        System.out.println("========================================");
        System.out.println("Terima kasih!");
        System.out.println("========================================");
    }

    private String formatRupiah(double nilai) {
        return String.format(Locale.US, "%,.0f", nilai).replace(',', '.');
    }
}
