public class Teh extends Minuman {
    public Teh(int id, String nama, int harga) {
        super(id, nama, harga);
    }

    @Override
    public String getRasa() {
        return "manis dan menyegarkan";
    }
}
