# places-service

### Summary

Microservice which allows you to search for a place by name and return the recommended or popular venues near that location, using the [Foursquare API](https://developer.foursquare.com/) and returning the results in JSON format.

### Requirements
* Java 1.8
* Maven 3.3.1 or higher
  * We use [Maven Wrapper](https://github.com/takari/takari-maven-plugin) to ensure projects can have their own versions of Maven and not rely on the operating system

### Build

Use Maven to install dependencies and build the artifact:
```
./mvnw clean package
```

## Run

Run the application locally:

* **Maven**:

```
./mvnw spring-boot:run
```

or

* **Docker**

    Build an image from the `Dockerfile`

    1. `docker build -t places-service .`
    
    the `t` option names and optionally tags the built image. If no tag is specified, the image is tagged as 'latest' by default.
    
    Create and run a container from the image
    
    1. `docker run -i -t -p 8080:8080 -p 9443:9443 --name plcs places-service`
    
    the `i` option runs the container in interactive mode and keeps STDIN open
    
    the `t` option allocates a pseudo-TTY to keep the interactive session open

    the `p` option publishes the container's port(s) to the host

    the `--name` option assigns a name to the container (to make it easier for us to manage containers instead of using the container ID)
 
    Alternatively, if you would like to run the container in the background, use:
    
    1. `docker run -d -p 8080:8080 -p 9443:9443 --name plcs places-service`
   
    the `-d` option runs the container in background and print container ID

    You can use the following command to tail the logs of the container as it starts up:
    
    `docker logs --tail=all -f plcs`

View the application here: [http://localhost:8080](http://localhost:8080)

### Swagger

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
