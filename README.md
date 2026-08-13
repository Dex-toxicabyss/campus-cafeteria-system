# Campus Cafeteria System — Lab OOP Week 14

This repository contains a runnable Java console implementation of the **Campus Cafeteria Management System** from the Week 14 guided Object-Oriented Programming lab. The implementation follows the supplied lab structure: products with stock, food discount rules, a transaction using parallel `ArrayList`s, and a checked/unchecked custom-exception hierarchy.

## Lab requirements implemented

| Requirement | Implementation |
| --- | --- |
| Abstract class | `Produk` holds protected `nama`, `harga`, and `stok`; it declares abstract `getKategori()`. |
| Interface | `Diskonable` provides `hitungDiskon()` and `getHargaSetelahDiskon()`. |
| Inheritance and polymorphism | `Makanan` and `Minuman` extend `Produk`; `Main` displays a `Produk[]` menu in one loop. |
| Discount | `Makanan` receives a 10% discount only when `harga > 15000`; `Minuman` has no discount. |
| Parallel lists | `Transaksi` stores `ArrayList<Produk>` and `ArrayList<Integer>` together for ordered products and quantities. |
| Custom exceptions | `KantinException`, `StokTidakCukupException`, `ProdukTidakDitemukanException`, and unchecked `DataTidakValidException`. |
| Exception handling | `Main` demonstrates specific catch, multi-catch, catch through the parent class, and `finally`. |

## Class structure

```text
src/
├── Diskonable.java
├── Produk.java                       # abstract
├── Makanan.java                      # extends Produk, implements Diskonable
├── Minuman.java                      # extends Produk
├── KantinException.java              # checked base exception
├── StokTidakCukupException.java      # checked
├── ProdukTidakDitemukanException.java# checked
├── DataTidakValidException.java      # unchecked
├── Transaksi.java                    # parallel ArrayList order model
└── Main.java                         # normal and error scenarios
```

All classes are intentionally in the **default package**, matching the BlueJ project convention specified in the lab.

## Run locally

Compile and run from the repository root with a standard JDK:

```bash
javac -d out src/*.java
java -cp out Main
```

The program prints a polymorphic menu, a receipt for **Budi Santoso**, and readable messages for insufficient stock, product-not-found, multi-catch, parent-class catch, and invalid data scenarios.

## Scope note

The original source file was unavailable. This repository is a clean reconstruction based directly on the supplied Week 14 lab brief, so it is presented as a course-aligned implementation rather than the exact historical submission.
