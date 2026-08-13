# Week 14 Requirement Traceability

This matrix connects each stated lab requirement to the exact implementation location so the project is easier to inspect and explain during a practical review.

| Lab requirement | Evidence in repository |
| --- | --- |
| `Diskonable` has `hitungDiskon()` and `getHargaSetelahDiskon()` | `src/Diskonable.java` |
| `Produk` is abstract with protected `nama`, `harga`, and `stok` | `src/Produk.java` |
| Invalid name, negative price, or negative stock uses an unchecked exception | `Produk` constructor and `src/DataTidakValidException.java` |
| Stock reduction declares and throws a checked exception | `Produk.kurangiStok()` and `src/StokTidakCukupException.java` |
| Food implements 10% discount only above Rp15.000 | `src/Makanan.java` |
| Beverage is a product subtype without discount behavior | `src/Minuman.java` |
| Custom checked exception family has one common parent | `KantinException`, `StokTidakCukupException`, and `ProdukTidakDitemukanException` |
| Transaction uses two parallel `ArrayList`s | `src/Transaksi.java` |
| Lookup throws when a product is absent | `Transaksi.cariProduk()` |
| Total uses food post-discount price and normal drink price | `Transaksi.hitungTotal()` |
| Receipt marks discounted food and displays total | `Transaksi.cetakStruk()` |
| Main uses specific catch, multi-catch, parent catch, and `finally` | `src/Main.java` |

## Explanation prompts

Use these questions to prepare for a lab review:

1. Why does `kurangiStok()` declare `throws StokTidakCukupException` while the product constructor does not declare `throws DataTidakValidException`?
2. Why is `Makanan` the only class that implements `Diskonable`?
3. Why must `daftarProduk` and `jumlahPesan` always be updated together?
4. Why is `catch (KantinException e)` useful after specific catches have been demonstrated?
