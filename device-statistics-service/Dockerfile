FROM ubuntu:22.04

ARG APP_VERSION=0.0.1-SNAPSHOT

# Avoid interactive prompts
ENV DEBIAN_FRONTEND=noninteractive

# Install dependencies
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk # postgresql postgresql-contrib && \
    apt-get clean

# Configure PostgreSQL
#USER postgres
#RUN /etc/init.d/postgresql start && \
#    psql --command "CREATE USER admin WITH PASSWORD 'admin';"
#    #&& \
#    #psql --command "CREATE DATABASE devices OWNER admin;"

#USER root

# Copy application jar
COPY build/libs/device-statistics-service-${APP_VERSION}.jar device-statistics-service.jar

# Expose port
EXPOSE 8091

# Start PostgreSQL + App
#CMD service postgresql start && java -jar device-statistics-service.jar
CMD java -jar device-statistics-service.jar
