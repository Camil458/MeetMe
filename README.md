# MeetMe - backend
This project is a backend part of a web application created for quick and easy event search. The application should be launched simultaneously with the frontend part available [HERE](https://github.com/WSokoll/MeetMe-frontend).

## Features
 - registration and login to the website
 - serching for events by entering a phrase and specifying the time
 - displaying search results using a list and markers on the map
 - displaying details such as date, place, description, availability of tickets for a specific event
 - creating and adding events marked as private (only for logged in users)

## Project setup
To run the project, it is necessary to connect to the database, enter the api keys and set up the mail service. In the ***application-prod.properties*** file:

### Set database
```
spring.datasource.username= #dbname
spring.datasource.password= #password
spring.datasource.url= #database url
```

### Set mail service
```
spring.mail.host= #smtp mail host
spring.mail.username= #username
spring.mail.password= #password
```

### Set [SerpApi](https://serpapi.com/google-events-api) key

```
api_key = f74c...
```

### Set [Geoapify](https://www.geoapify.com/geocoding-api) key
```
geo_api_key = ecb...
```

## Technology stack
- Spring 
- Hibernate
- MySQL

## Authors
 - [Władysław Sokołowski](https://github.com/WSokoll)
 - [Kamil Radłowski](https://github.com/Camil458)
