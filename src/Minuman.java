/**
 * Base abstraction for a drink sold by the campus cafeteria.
 */
public abstract class Minuman {
    private final int id;
    private final String nama;
    private final int harga;

    protected Minuman(int id, String nama, int harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public abstract String getRasa();

    public String tampilkanInfo() {
        return String.format("%d. %s — Rp%,d (%s)", id, nama, harga, getRasa());
    }
}
