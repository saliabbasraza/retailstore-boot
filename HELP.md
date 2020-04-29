# Getting Started

### Run
* Run ``mvn spring-boot:run`` **OR**  ``./mvnw spring-boot:run``
* Open http://localhost:8080/ in browser.

###Test Bill Calculation
Curl
```
   curl --location --request POST 'http://localhost:8080/bill' \
   --header 'Content-Type: application/json' \
   --data-raw '{
       "groceryTotal": 490,
       "nonGroceryTotal": 500,
       "customer": {
           "id": 3
       }
   }'
```
Response    
```
{
    "id": 1,
    "customer": {
        "id": 3,
        "name": "Employee User",
        "dateCreated": "2020-04-29T22:40:06.038",
        "type": "EMPLOYEE"
    },
    "groceryTotal": 490.0,
    "nonGroceryTotal": 500.0,
    "netPayable": 795.0,
    "discount": 195.0,
    "total": 990.0
}

```

### Build & Test
* Run ``mvn clean verify`` **OR**  ``./mvnw clean verify``

### Test Coverage
* Run ``mvn clean verify`` **OR**  ``./mvnw clean verify``
* Open ``target/site/jacoco/index.html`` in browser to see complete coverage report.

###PMD
* Run ``mvn pmd:check`` **OR**  ``./mvnw pmd:check``
    - It will check for basic code smells.

