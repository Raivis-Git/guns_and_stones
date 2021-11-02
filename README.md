# guns_and_stones
To run application you will need :
  Java 11
  Maven

To run application use command:  mvn spring-boot:run
Application will start on port 8080

Uses json


Post method to create a new device
  http://localhost:8080/api/device
  {
    "deviceType": "access point", 
    "macAddress": "12311", 
    "uplinkMacAddress": "127.0.0.1" 
  }
  
Get method to get top 10 with biggest population
  http://localhost:8080/api/country/top10WithBiggestPopulation
  
Get method to get top 10 with biggest area
  http://localhost:8080/api/country/top10WithBiggestArea
  
Get method to get top 10 with biggest population density
  http://localhost:8080/api/country/top10WithBiggestPopulationDensity
