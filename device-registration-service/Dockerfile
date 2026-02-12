FROM ubuntu:22.04

ARG APP_VERSION=0.0.1-SNAPSHOT

# Avoid interactive prompts
ENV DEBIAN_FRONTEND=noninteractive

# Install dependencies
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk # postgresql postgresql-contrib && \
    apt-get clean

# Copy application jar
COPY build/libs/device-registration-service-${APP_VERSION}.jar device-registration-service.jar

# Expose port
EXPOSE 8092

# Start PostgreSQL + App
CMD java -jar device-registration-service.jar
