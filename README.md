# shopping-basket/ShoppingBasket

## Description
ShoppingBasket processes shopping basket items and outputs the total price based on given input

## Building the Application
To build this application, ensure you have Maven installed and run the following command from the root of the project:
```bash
mvn clean package
```

## Running the Application

After building the application, you can run it using the following command:
```bash
java -jar target/shopping-basket-1.0-SNAPSHOT.jar "arg1" "arg2" ... "argN"
```
Replace `arg1`, `arg2`, ..., `argN` with the desired arguments, these are the items in the shopping basket.

Possible items: 
 - `Apple`
 - `Banana`
 - `Melon`
 - `Lime`

## Example

```bash
> java -jar target/shopping-basket-1.0-SNAPSHOT.jar "Lime" "Melon" "Melon" "Melon" "Lime" "Lime"
Total cost of the basket: 130p
```
