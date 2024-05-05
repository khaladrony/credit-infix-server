FROM openjdk:11
# ENV SPRING_PROFILES_ACTIVE=production
# COPY /home/rony/Desktop/WAR_FILE/14-11-23/backend/credit-infix-server.jar /usr/app/
#WORKDIR /credit-infix-server
#COPY . .
#RUN mvn clean install
#
#CMD mvn spring-boot:run

# Expose the application port
EXPOSE 8089

COPY target/credit-infix-server.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "credit-infix-server.jar"]