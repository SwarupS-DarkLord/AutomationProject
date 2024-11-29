# Use OpenJDK 21 as base image
FROM amazoncorretto:21
# Copy source files into the container
COPY src home/app/src
COPY testng.xml home/app/TestNG
COPY pom.xml home/app/pom.xml
# Set working directory
WORKDIR home/apiframework/src
ENTRYPOINT mvn clean test