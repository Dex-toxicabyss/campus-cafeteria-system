/**
 * Abstract blueprint for all cafeteria products.
 */
public abstract class Produk {
    protected String nama;
    protected double harga;
    protected int stok;

    public Produk(String nama, double harga, int stok) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new DataTidakValidException("Nama produk tidak boleh kosong.");
        }
        if (harga < 0) {
            throw new DataTidakValidException("Harga produk tidak boleh negatif.");
        }
        if (stok < 0) {
            throw new DataTidakValidException("Stok produk tidak boleh negatif.");
        }

        this.nama = nama.trim();
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok(int jumlah) throws StokTidakCukupException {
        if (jumlah <= 0) {
            throw new DataTidakValidException("Jumlah pesanan harus lebih dari nol.");
        }
        if (jumlah > stok) {
            throw new StokTidakCukupException(
                "Stok " + nama + " tidak cukup. Diminta: " + jumlah + ", tersedia: " + stok + "."
            );
        }
        stok -= jumlah;
    }

    public abstract String getKategori();

    public void tampilkanInfo() {
        System.out.println("Nama     : " + nama);
        System.out.println("Kategori : " + getKategori());
        System.out.printf("Harga    : Rp %,.0f%n", harga);
        System.out.println("Stok     : " + stok);
    }
}
