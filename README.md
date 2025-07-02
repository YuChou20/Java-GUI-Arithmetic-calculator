# 🧮 Java GUI Calculator

A graphical calculator application built in Java using AWT. Supports basic arithmetic operations with a clean interface and custom expression evaluation logic.

---

### Why build this?

This project was built as a hands-on exercise in combining Java GUI development with custom data structures and expression parsing. It showcases how lower-level components like stacks and manual parsing can be used in real applications.

## 🔧 Features

- **Basic Arithmetic**: Supports `+`, `-`, `*`, `/` operations.
- **Negative Numbers & Decimals**: Handles real numbers and sign toggling.
- **Custom Expression Parser**: Converts infix expressions to postfix (Reverse Polish Notation) for evaluation.
- **Manual Stack Implementation**: Uses a self-implemented generic stack (`Mystack<T>`) for expression evaluation.
- **History Display**: Shows full calculation history in the UI.
- **Backspace & Clear Functions**: Intuitive controls for editing input.
- **Responsive GUI**: Built with Java AWT, using manual layout positioning for pixel-perfect control.

---

## 🛠️ Technologies Used

- **Java AWT**: For GUI components (`Frame`, `Button`, `Label`, etc.)
- **Event Handling**: Managed via `ActionListener` for all user input.
- **Custom Stack Structure**: Manually implemented generic iterable stack.
- **Infix to Postfix Conversion**: For parsing and evaluating expressions.
- **Object-Oriented Programming**: Clear separation of concerns and encapsulation.

---

## Getting Started
To compile and run the calculator:
```
javac Arithmetic_calculator.java
java Arithmetic_calculator
```
Requires Java 8 or higher

---
