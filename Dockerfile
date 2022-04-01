# we will use openjdk 8 with alpine as it is a very small linux distro
FROM williamyeh/java8
ARG JAR_FILE=target/conversor-num-romano-0.0.1-SNAPSHOT.jar

WORKDIR /usr/local/runme

# copy the packaged jar file into our docker image
COPY ${JAR_FILE} app.jar

# set the startup command to execute the jar
ENTRYPOINT ["java", "-jar", "app.jar"]