public class Matcha extends Minuman {
    public Matcha(int id, String nama, int harga) {
        super(id, nama, harga);
    }

    @Override
    public String getRasa() {
        return "creamy dengan aroma teh hijau";
    }
}
