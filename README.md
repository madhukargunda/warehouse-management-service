# warehouse-management-service
 
 ### Adding Car to Inventory
 
 ```
 curl --location --request POST 'http://localhost:8080/whms/cars' \
--header 'Content-Type: application/json' \
--data-raw '{
"description":"TATA ALTO",
"make": 2022,
"model":"TATA-2020",
"price": 250003.34,
"name": "TATA ALTO"

}'
```
### Retriving all cars from inventory 

```
curl --location --request GET 'http://localhost:8080/whms/cars'

```

### Purchase a Car by passing the car id and final price value

```
curl --location --request POST 'http://localhost:8080/whms/cars/1/buy/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "finalPrice": 1200.77
}'

```
