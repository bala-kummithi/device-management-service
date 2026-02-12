# Device Management Service

## Architecture

- device-statistics-service (public)
- device-registration-service (internal)
- PostgreSQL database

## Run with Docker Compose

docker-compose up --build

Statistics API:
http://localhost:8080

Device API:
http://localhost:8081

## Kubernetes Deployment

kubectl apply -f k8s/

device-statistics-service → Public (LoadBalancer)
device-registration-service → Internal (ClusterIP)

## Build Docker Images

mvn clean package
docker build -t balakummithi/device-statistics-service:1.0 device-registration-service/
docker build -t balakummithi/device-registration-service:1.0 device-registration-service/
