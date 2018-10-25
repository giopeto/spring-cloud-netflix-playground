# spring-cloud-netflix-playground

## Links

### Discovery server
Discovery server [http://localhost:8761/](http://localhost:8761)

Discovery server username/password: admin/admin

### Hystrix client service
Hystrix client service [http://localhost:8082](http://localhost:8082)

Hystrix client service hystrix stream url [http://localhost:8082/actuator/hystrix.stream](http://localhost:8082/actuator/hystrix.stream)

### Hystrix dashboard
Hystrix dashboard [http://localhost:8081/hystrix](http://localhost:8081/hystrix)

### Actuator service
Actuator service [http://localhost:8080](http://localhost:8080)

Actuator service actuators list [http://localhost:8080/actuator](http://localhost:8080/actuator)

Actuator service health [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)

### Turbine
Turbine [http://localhost:8090](http://localhost:8090)

Turbine clusters[http://localhost:8090/clusters](http://localhost:8090/clusters)

Turbine HYSTRIX-CLIENT-SERVICE cluster [http://localhost:8090/turbine.stream?cluster=HYSTRIX-CLIENT-SERVICE](http://localhost:8090/turbine.stream?cluster=HYSTRIX-CLIENT-SERVICE)

### Zipkin (docker image)
Zipkin [http://localhost:9411](http://localhost:9411)

## Start Zipkin with docker

`docker run -d -p 9411:9411 openzipkin/zipkin`