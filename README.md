# Prova Sprint 1 - Fruit Shop Inventory System

## Overview

This project implements an inventory management system for a fruit shop, developed as part of a technical exam in Java. The solution was built strictly following Test-Driven Development (TDD) and based on a set of user stories and predefined unit tests.

## User Stories Addressed

1. **Product Registration**  
   The inventory supports both perishable and non-perishable products.
    - All products have a name, price, and stock quantity.
    - Perishable products additionally store an expiration date.
    - The system can check if a perishable product is expired.

2. **Product Search**  
   It is possible to search for products by name, case-insensitive.
    - If a product is not found, a specific exception is thrown.

3. **Low Stock Identification**  
   The system can return all products with stock below a configurable threshold.

4. **Total Inventory Value Calculation**  
   The total value of the inventory is computed as the sum of each product's (price × quantity).

5. **Discount Application**  
   Products support applying custom discounts with a message indicating the reason.
    - The final price after discount is returned.
    - If the product is perishable, an additional 2% discount is automatically applied.

## Main Features and Implementation Details

- **Class Hierarchy and Encapsulation:**  
  The model distinguishes between perishable and non-perishable products using inheritance with proper encapsulation.
- **Exception Handling:**  
  Custom exceptions (such as `ProductNotFoundException` and `DuplicateProductException`) are implemented for error scenarios, in line with robust software practices.
- **Discounts and Business Logic:**  
  The discount logic is implemented so that for perishable products, the discount includes an extra 2% based on the base price, according to the requirements.
- **Case-Insensitive Search and Inventory Management:**  
  Methods are implemented to ensure product lookup is case-insensitive and to manage adding, searching, and listing products correctly.
- **TDD and Test Compliance:**  
  All code was written iteratively, using the provided unit tests as the specification. All tests pass successfully, confirming compliance with functional requirements and edge cases.

## Skills Demonstrated

- **Object-Oriented Programming (OOP):**  
  Applied inheritance, composition, interface implementation, and encapsulation for a clear and extensible design.
- **Exception Handling:**  
  Defined and managed custom exceptions to control error flows and ensure reliable operation.
- **Collections API:**  
  Managed products using Java collections (`Set`, etc.) effectively, demonstrating safe iteration, filtering, and storage.
- **Streams and Lambdas:**  
  Used Java streams and lambda expressions for operations like filtering low-stock products and calculating inventory value.
- **TDD and Analytical Problem Solving:**  
  Translated user stories and tests into implementation, refining the solution until all tests passed.
- **Attention to Business Rules:**  
  Correctly handled domain-specific details, such as perishable product expiration and discount calculation.

## How to Build and Test

1. Clone the repository.
2. Ensure you have Java 17+ and your favorite Java IDE or build tool.
3. Run the provided unit tests to validate the implementation.

All logic has been organized using packaging best practices for clear separation of concerns (model, exception, service/manager).

---

This submission represents a full-cycle implementation process from requirements analysis to the passing of comprehensive test suites, showcasing a strong command of Java programming, OOP fundamentals, and modern development methodologies.
