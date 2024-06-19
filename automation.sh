#!/bin/bash

# Start the Selenium server
java -jar /opt/selenium/selenium-server-standalone.jar &

# Wait for the Selenium server to start
sleep 5

# Run the tests
mvn -f /app/pom.xml test

