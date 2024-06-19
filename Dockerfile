# Use an official Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the project files
COPY pom.xml .
COPY src ./src
COPY testng.xml .
COPY ConfigFile ./ConfigFile
COPY Credentials ./Credentials
COPY UrlFile ./UrlFile

# Copy chromedriver
COPY ./Chromedriver /app/Chromedriver/chromedriver

# Package the application
RUN mvn clean

# Use a smaller base image for running the application with Chrome
FROM selenium/standalone-chrome:latest

# Set the working directory
WORKDIR /app


# Copy any required additional files (e.g., configuration files)
COPY ConfigFile /app/ConfigFile
COPY Credentials /app/Credentials
COPY UrlFile /app/UrlFile
COPY automation.sh /app/automation.sh
COPY ./Chromedriver /app/Chromedriver/chromedriver

# # Ensure the chromedriver is executable and check its existence
# RUN chmod +x /app/Chromedriver/chromedriver && ls -l /app/Chromedriver/chromedriver

# Debugging step: List files and their permissions in /app directory
# RUN ls -l /app && ls -l /app/Chromedriver && ls -l /app/Chromedriver/chromedriver && ls -l /app/automation.sh
USER root
# Set the entrypoint script to be executable
RUN chmod +x /app/automation.sh

# Define the command to run the tests
CMD ["/app/automation.sh"]
