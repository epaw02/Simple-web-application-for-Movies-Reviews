FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="0.0.1-SNAPSHOT"

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:testdb-movie
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=sa1
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true
ENV REVIEW_URL=http://localhost:8081

EXPOSE 8080
EXPOSE 8082

COPY target/movies-${VERSION}.jar /opt/movies/movies.jar

CMD ["java", "-jar", "/opt/movies/movies.jar"]