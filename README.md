# Selenium Demo

What is being used here?

As usual, it is a java project so the dependencies are listed below

```text
1. JAVA

2. Maven

3. TestNG
```

## How to run?

### Run everything (not recommended)

```shell
mvn test
```
### Run single test method

```shell
mvn -Dtest=className#testMethodName test
```

### Run single class

```shell
mvn -Dtest=className test
```

### View Reports

Please view html in target folder

```text
dir/selenium_demo/target/surefire-reports/index.html#
```