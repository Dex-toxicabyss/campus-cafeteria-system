# Class Diagram

The diagram below reflects the structure compiled by BlueJ. All source classes intentionally remain in the default package, so this document is a reference rather than another package layer.

```mermaid
classDiagram
    direction LR

    class Diskonable {
        <<interface>>
        +hitungDiskon() double
        +getHargaSetelahDiskon() double
    }

    class Produk {
        <<abstract>>
        #nama String
        #harga double
        #stok int
        +getNama() String
        +getHarga() double
        +getStok() int
        +kurangiStok(jumlah int) void
        +getKategori() String
        +tampilkanInfo() void
    }

    class Makanan {
        -jenisMenu String
        +getKategori() String
        +hitungDiskon() double
        +getHargaSetelahDiskon() double
        +tampilkanInfo() void
    }

    class Minuman {
        -ukuranMl int
        +getKategori() String
        +tampilkanInfo() void
    }

    class Transaksi {
        -namaPelanggan String
        -daftarProduk ArrayList~Produk~
        -jumlahPesan ArrayList~Integer~
        +tambahProduk(produk Produk, jumlah int) void
        +cariProduk(nama String) Produk
        +hitungTotal() double
        +cetakStruk() void
    }

    class KantinException {
        +KantinException(pesan String)
    }

    class StokTidakCukupException
    class ProdukTidakDitemukanException
    class DataTidakValidException

    Produk <|-- Makanan
    Produk <|-- Minuman
    Diskonable <|.. Makanan
    Transaksi o-- Produk : menyimpan pesanan
    KantinException <|-- StokTidakCukupException
    KantinException <|-- ProdukTidakDitemukanException
```

## Design decisions

`Produk` contains common product state and enforces stock reduction through `kurangiStok()`. This means `Transaksi` does not mutate stock directly. `Makanan` owns the discount behavior because the lab only gives food a discount; `Minuman` deliberately does not implement `Diskonable`.

`Transaksi` demonstrates polymorphism by storing both product subtypes in one `ArrayList<Produk>`. The paired `jumlahPesan` list preserves the quantity for the product at the same index. `KantinException` creates one checked-exception family that can be caught either specifically or through its parent type.
