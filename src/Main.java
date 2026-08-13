/**
 * Runs all normal and exception-handling scenarios required by the Week 14 lab.
 */
public class Main {
    public static void main(String[] args) {
        Makanan nasiGoreng = new Makanan("Nasi Goreng Spesial", 12000, 10, "Nasi");
        Makanan ayamGoreng = new Makanan("Ayam Goreng Crispy", 18000, 5, "Lauk");
        Minuman esTeh = new Minuman("Es Teh Manis", 5000, 20, 350);
        Minuman jusAlpukat = new Minuman("Jus Alpukat", 12000, 8, 250);

        Produk[] menu = { nasiGoreng, ayamGoreng, esTeh, jusAlpukat };
        System.out.println("=== MENU KANTIN ===");
        for (Produk produk : menu) {
            produk.tampilkanInfo();
            System.out.println("----------------------------------------");
        }

        Transaksi transaksi = new Transaksi("Budi Santoso");

        try {
            transaksi.tambahProduk(ayamGoreng, 2);
            transaksi.tambahProduk(esTeh, 1);
            transaksi.cetakStruk();
        } catch (StokTidakCukupException exception) {
            System.out.println("Gagal: " + exception.getMessage());
        } finally {
            System.out.println("[Transaksi 1 selesai diproses]");
        }

        try {
            transaksi.tambahProduk(ayamGoreng, 10);
        } catch (StokTidakCukupException exception) {
            System.out.println("Error stok: " + exception.getMessage());
        }

        try {
            transaksi.cariProduk("Sate Padang");
        } catch (ProdukTidakDitemukanException exception) {
            System.out.println("Error pencarian: " + exception.getMessage());
        }

        try {
            Produk produk = transaksi.cariProduk("Es Teh Manis");
            transaksi.tambahProduk(produk, 999);
        } catch (StokTidakCukupException | ProdukTidakDitemukanException exception) {
            System.out.println("Error transaksi: " + exception.getMessage());
        }

        try {
            transaksi.cariProduk("Produk Tidak Ada");
        } catch (KantinException exception) {
            System.out.println("Error bisnis: " + exception.getMessage());
        }

        try {
            new Minuman("", -100, 5, 200);
        } catch (DataTidakValidException exception) {
            System.out.println("Error data: " + exception.getMessage());
        }
    }
}
