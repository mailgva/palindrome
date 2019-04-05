Requirements (basic):
A user can input a number of any length (max long is LIMIT) into form
 Program must calculate 2 palindromes: 
closest below user number (“Min” in UI)
closest above user number (“Max” in UI)
If user entered palindrome, show dialog/alert, that number is already palindrome, without starting of calculation
For long calculation in the history should be a card with information about the calculation
A user can invoke a few independent calculations
After page reloading restore history without interruption of the calculation
Drop calculation if the user leaves the page (close)

Requirements (optional/advanced):
- Provide security and registration
+ For unregistered users, max possible input is 999999, for registered unlimited
+ For registered users don’t drop calculation if page closed
+ For registered users show all history by pagination or infinite scrolling

Technologies (primary):
+ Java 11
+ Spring Boot (2.1.3 ), Security, Data
+ Front-end any (Thymeleaf)
+ Embeddable database (HSQLDB) (in-memory/file)


Тесты не сделаны. 
 
Запуск: mvn spring-boot:run