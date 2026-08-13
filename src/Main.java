import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Console entry point for the Campus Cafeteria System.
 *
 * The app intentionally demonstrates abstraction, inheritance, interfaces,
 * polymorphism, ArrayList, HashMap, input validation, exception handling, and File I/O.
 */
public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Map<Integer, String> MENU = new HashMap<Integer, String>();
    private static final List<ItemPesanan> PESANAN = new ArrayList<ItemPesanan>();

    public static void main(String[] args) {
        siapkanMenu();
        System.out.println("========================================");
        System.out.println("       CAMPUS CAFETERIA SYSTEM");
        System.out.println("========================================");

        boolean lanjut = true;
        while (lanjut) {
            tampilkanMenu();
            int pilihan = bacaAngka("Pilih menu (1-3, 0 untuk selesai): ");

            if (pilihan == 0) {
                lanjut = false;
                continue;
            }

            try {
                String namaMenu = MENU.get(pilihan);
                if (namaMenu == null) {
                    throw new IllegalArgumentException("Pilihan tidak tersedia.");
                }

                Minuman minuman = buatMinuman(pilihan);
                int jumlah = bacaJumlah();
                aturToppingJikaTersedia(minuman);

                PESANAN.add(new ItemPesanan(minuman, jumlah));
                System.out.println("Ditambahkan: " + minuman.getNama() + " x" + jumlah + ".\n");
                lanjut = bacaYaTidak("Tambah pesanan lagi? (y/n): ");
            } catch (IllegalArgumentException exception) {
                System.out.println("Error: " + exception.getMessage() + "\n");
            }
        }

        if (PESANAN.isEmpty()) {
            System.out.println("Belum ada pesanan. Program selesai.");
            return;
        }

        String ringkasan = buatRingkasanPesanan();
        System.out.println("\n" + ringkasan);
        simpanPesanan(ringkasan);
    }

    private static void siapkanMenu() {
        MENU.put(1, "Americano");
        MENU.put(2, "Teh Botol");
        MENU.put(3, "Matcha Latte");
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== MENU MINUMAN ===");
        for (int id = 1; id <= MENU.size(); id++) {
            System.out.println(buatMinuman(id).tampilkanInfo());
        }
    }

    private static Minuman buatMinuman(int pilihan) {
        switch (pilihan) {
            case 1:
                return new Kopi(1, "Americano", 18000);
            case 2:
                return new Teh(2, "Teh Botol", 8000);
            case 3:
                return new Matcha(3, "Matcha Latte", 20000);
            default:
                throw new IllegalArgumentException("Pilihan tidak tersedia.");
        }
    }

    private static void aturToppingJikaTersedia(Minuman minuman) {
        if (!(minuman instanceof Toppingable)) {
            return;
        }

        if (bacaYaTidak("Tambah topping cream atau caramel? (y/n): ")) {
            System.out.print("Masukkan topping: ");
            String topping = INPUT.nextLine();
            ((Toppingable) minuman).tambahTopping(topping);
        }
    }

    private static int bacaJumlah() {
        while (true) {
            int jumlah = bacaAngka("Jumlah pesanan: ");
            if (jumlah > 0) {
                return jumlah;
            }
            System.out.println("Jumlah harus lebih dari nol.");
        }
    }

    private static int bacaAngka(String pesan) {
        while (true) {
            System.out.print(pesan);
            String nilai = INPUT.nextLine();
            try {
                return Integer.parseInt(nilai.trim());
            } catch (NumberFormatException exception) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
    }

    private static boolean bacaYaTidak(String pesan) {
        while (true) {
            System.out.print(pesan);
            String jawaban = INPUT.nextLine().trim().toLowerCase();
            if (jawaban.equals("y") || jawaban.equals("ya")) {
                return true;
            }
            if (jawaban.equals("n") || jawaban.equals("tidak")) {
                return false;
            }
            System.out.println("Jawab dengan y atau n.");
        }
    }

    private static String buatRingkasanPesanan() {
        StringBuilder ringkasan = new StringBuilder();
        ringkasan.append("=== RINGKASAN PESANAN ===\n");
        int total = 0;
        for (ItemPesanan item : PESANAN) {
            ringkasan.append("- ").append(item.tampilkanRingkasan()).append("\n");
            total += item.getSubtotal();
        }
        ringkasan.append(String.format("Total: Rp%,d\n", total));
        ringkasan.append("Terima kasih telah memesan di kantin kampus.");
        return ringkasan.toString();
    }

    private static void simpanPesanan(String ringkasan) {
        try (FileWriter file = new FileWriter("pesanan.txt")) {
            file.write("Dibuat: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + "\n\n");
            file.write(ringkasan);
            System.out.println("Pesanan berhasil disimpan ke pesanan.txt.");
        } catch (IOException exception) {
            System.out.println("Gagal menyimpan pesanan: " + exception.getMessage());
        }
    }
}
