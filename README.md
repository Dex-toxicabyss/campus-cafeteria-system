# Campus Cafeteria System

Campus Cafeteria System is a runnable Java console application developed from the supplied Object-Oriented Programming course brief. It models a small beverage-ordering flow in a campus cafeteria.

## Snapshot

| Item | Detail |
| --- | --- |
| Project type | Academic PBO project |
| Language | Java |
| Interface | Console application |
| Main concepts | Abstraction, interfaces, inheritance, polymorphism, collections, exception handling, file I/O |
| Status | Runnable source included |

## Features

The program shows three drinks, validates menu and quantity input, allows several items to be added to one order, supports an optional topping for coffee, calculates a total, and exports the final receipt to `pesanan.txt`.

The implementation is deliberately scoped to the course material. `Minuman` is an abstract class; `Kopi`, `Teh`, and `Matcha` extend it; and `Kopi` implements `Toppingable`. The console flow uses `HashMap` for menu lookup, `ArrayList` for the active order, `try`/`catch`-style validation, and `FileWriter` for receipt persistence.

## Project structure

```text
src/
├── Main.java          # Console flow, validation, order export
├── Minuman.java       # Abstract base class
├── Kopi.java          # Inheritance + Toppingable implementation
├── Teh.java           # Drink subtype
├── Matcha.java        # Drink subtype
├── Toppingable.java   # Topping interface
└── ItemPesanan.java   # Order-line model
```

## Run locally

Use any JDK that supports standard Java compilation. From the repository root, run:

```bash
javac -d out src/*.java
java -cp out Main
```

After an order is completed, the receipt is written to `pesanan.txt` in the repository root. The file is intentionally ignored by Git because it is generated at runtime.

## Scope and provenance

The original Java source file was no longer available when this repository was published. The current source is a clean, runnable reconstruction based on the supplied PBO practical brief: abstract `Minuman`, `Toppingable`, drink subclasses, `ArrayList`, `HashMap`, input validation, exception handling, and file I/O. It is therefore presented as a course-aligned implementation rather than a claim that this is the exact original submission.

This is a focused academic console project, not a production ordering platform.
