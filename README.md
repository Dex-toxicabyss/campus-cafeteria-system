# Campus Cafeteria System — Lab OOP Week 14

> A runnable Java console implementation of the guided Week 14 **Campus Cafeteria Management System** lab. The source is intentionally kept in the **default package** to remain compatible with the BlueJ workflow specified by the lab.

This project demonstrates how core object-oriented design, collection handling, and exception control work together in a small transactional domain. A cashier can assemble a customer order from food and beverage products, calculate the correct discount and total, reduce available stock, and receive clear feedback when an order is invalid.

## Highlights

| Area | What the implementation demonstrates |
| --- | --- |
| Object model | Abstract `Produk` base class with specialised `Makanan` and `Minuman` subclasses. |
| Polymorphism | A `Produk[]` menu is rendered through one loop while each subtype displays its own information. |
| Discount rule | `Makanan` implements `Diskonable`: a 10% discount applies only when the unit price is greater than Rp15.000. |
| Transaction state | `Transaksi` keeps `ArrayList<Produk>` and `ArrayList<Integer>` aligned as parallel lists. |
| Error handling | Checked business exceptions for stock/product lookup; unchecked validation errors for bad source data. |
| Demonstration | `Main` covers a successful order, insufficient stock, failed lookup, multi-catch, parent-class catch, and `finally`. |

## Class structure

```text
src/
├── Diskonable.java                    # interface: discount contract
├── Produk.java                        # abstract product blueprint
├── Makanan.java                       # extends Produk, implements Diskonable
├── Minuman.java                       # extends Produk
├── KantinException.java               # checked business-error base class
├── StokTidakCukupException.java       # checked: unavailable stock
├── ProdukTidakDitemukanException.java # checked: product is absent from a transaction
├── DataTidakValidException.java       # unchecked: invalid object data
├── Transaksi.java                     # customer order using parallel ArrayLists
└── Main.java                          # complete lab scenario
```

The diagram and method-level relationships are documented in [Class Diagram](docs/CLASS_DIAGRAM.md). A direct mapping between the lab requirements and implementation is available in [Requirement Traceability](docs/REQUIREMENT_TRACEABILITY.md).

## Run locally

The project is tested with **JDK 21** and uses no external library. From the repository root:

```bash
javac -d out src/*.java
java -cp out Main
```

The expected successful transaction is for **Budi Santoso**: two `Ayam Goreng Crispy` (discounted) and one `Es Teh Manis`, with a total of **Rp 37.400**. The program then proceeds through the required failure scenarios without letting an exception escape from `main`.

## Documentation

| Document | Purpose |
| --- | --- |
| [Class Diagram](docs/CLASS_DIAGRAM.md) | Visual class, inheritance, interface, and exception hierarchy reference. |
| [BlueJ Guide](docs/BLUEJ_GUIDE.md) | Steps to open, compile, and inspect the project in BlueJ. |
| [Requirement Traceability](docs/REQUIREMENT_TRACEABILITY.md) | Evidence that every Week 14 requirement has a corresponding implementation point. |
| [Testing Notes](docs/TESTING.md) | Reproducible compile/run command and expected test scenarios. |

## Scope note

The original source file was unavailable. This repository is a clean, course-aligned reconstruction based directly on the supplied Week 14 brief, not a claim that it is the exact historical submission. It is intentionally a focused academic console project rather than a production ordering platform.
