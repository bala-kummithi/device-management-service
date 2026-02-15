# Device Management Service

## Architecture

- device-statistics-service (public)
- device-registration-service (internal)
- PostgreSQL database

# Tech Stack

* Java Spring boot 4.x
* Gradle 9.x
* OpenJDK 17.x
* PostgresSQL 15-alpine

## Run with Docker Compose

docker-compose up --build

Device Statistics API:
http://localhost:8092

Device Registration API:
http://localhost:8091

## Kubernetes Deployment

kubectl apply -f k8s/

device-statistics-service → Public (LoadBalancer)
device-registration-service → Internal (ClusterIP)

## Build Docker Images

gradle clean build
docker build -t balakummithi/device-statistics-service:1.0 device-statistics-service/
docker build -t balakummithi/device-registration-service:1.0 device-registration-service/

## Security Scanning

Container images are scanned using Trivy.

trivy image postgres:15-alpine

No CRITICAL vulnerabilities found.

# Generate Certificate and private key 

Generate local development certificates:

openssl req -new -x509 -days 365 -nodes

-out server.crt -keyout server.key

-subj "/CN=localhost"
