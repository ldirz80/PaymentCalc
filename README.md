# Payment-Calc

From a supplied total amount and number of payments, calculate the recurring regular payment amount, and if required a different last amount  that includes any remainder.

## To Build - Windows

gradlew clean build test 

## To Build - Linux

./gradlew clean build test 

## Results

The build directory contains results for the following:

1. Code coverage (Jacoco)
2. Static Analysis (FindBugs)
3. Unit Test (JUnit)
4. A Jar file ( PaymentCalc-1.0.0.jar) containing the compiled code

## To run

usage: java -jar PaymentCalc-1.0.0.jar \<Total Amount> \<No of payments>





