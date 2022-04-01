# Compilar
* mvn install

# Run in docker
* docker build -t brevio/conversor-numeros-romanos .

* docker run --net=bridge -d -p 8080:8080 brevio/conversor-numeros-romanos .

