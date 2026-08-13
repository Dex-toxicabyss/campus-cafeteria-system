# Testing Notes

## Reproducible command

```bash
rm -rf out
javac -d out src/*.java
java -cp out Main
```

The project was compiled and executed with **JDK 21**. No external dependencies are required.

## Scenario checklist

| Scenario | Expected result |
| --- | --- |
| Menu polymorphism | Four `Produk` objects display subtype-specific information through a single loop. |
| Discount rule | `Ayam Goreng Crispy` costs Rp18.000 and receives a 10% unit discount. |
| Successful transaction | 2 × Ayam Goreng Crispy plus 1 × Es Teh Manis produces `TOTAL : Rp 37.400`. |
| `finally` block | `[Transaksi 1 selesai diproses]` prints after the first transaction. |
| Insufficient stock | Requesting 10 Ayam Goreng Crispy after ordering 2 reports 3 remaining. |
| Product lookup | Searching for `Sate Padang` raises `ProdukTidakDitemukanException`. |
| Multi-catch | Ordering 999 Es Teh Manis after one was ordered is handled by the multi-catch block. |
| Parent exception catch | Looking up a missing product is handled through `KantinException`. |
| Unchecked validation | Creating a drink with empty name/negative price is handled as `DataTidakValidException`. |

## Validation boundaries

The runtime test verifies the required console flow. The BlueJ object-bench checks in [BLUEJ_GUIDE.md](BLUEJ_GUIDE.md) are useful for manually demonstrating individual constructors and methods to an assistant or lecturer.

