# BlueJ Guide

## Open the project

1. Download or clone the repository and open the project folder in BlueJ.
2. Keep every `.java` file inside `src/` in the **default package**. Do not add a `package` declaration, because the supplied lab uses a flat BlueJ class diagram.
3. Compile all classes. BlueJ should render the inheritance arrows from `Produk` to `Makanan` and `Minuman`, the implementation arrow from `Makanan` to `Diskonable`, and the exception hierarchy below `KantinException`.

## Recommended object-bench checks

| Check | Action | Expected result |
| --- | --- | --- |
| Food discount | Create `new Makanan("Tes", 18000, 5, "Lauk")`, then call `getHargaSetelahDiskon()` | `16200.0` |
| No low-price discount | Create `new Makanan("Tes", 12000, 5, "Nasi")`, then call `hitungDiskon()` | `0.0` |
| Checked stock error | Call `kurangiStok(6)` on a food product with stock `5` | `StokTidakCukupException` dialog/message |
| Unchecked validation | Create `new Minuman("", -100, 5, 200)` | `DataTidakValidException` dialog/message |
| Parallel list order | Create a `Transaksi`, add one food and one drink, then call `cetakStruk()` | Both items appear with their corresponding quantities and total |

## Run the demonstration

Right-click `Main`, choose `void main(String[] args)`, and run it. The terminal should print the menu, successful receipt, and all error messages while reaching the end of the scenario cleanly.
