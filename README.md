## Environment:
- Java version: 1.17
- Maven version: 3.*
- Spring Boot version: 2.2.1.RELEASE

## Read-Only Files:
- src/test/*

## Documentation ##
<a href="https://docs.google.com/document/d/1ZefB-l3WN6OjFsjtPdazUhSu-2aArDYWrxs8ZSQ0Vg4/edit?usp=sharing" target="_blank">Link Documentation</a>


## Request:
Example of a price cURL:
```

curl --location --request GET 'http://localhost:8080/price?brandId=1&productId=35455&date=2020-06-16T21:00:00'

```

## Requirements:

//TODO COMMENTS


## Commands
- run: 
```bash
mvn clean package; java -jar target/prices-test-1.0-SNAPSHOT.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```


