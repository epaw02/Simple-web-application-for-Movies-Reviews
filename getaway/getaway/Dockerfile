FROM eclipse-temurin:17.0.6_10-jre

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

EXPOSE 8080
EXPOSE 8083
EXPOSE 8082

COPY target/getaway-${VERSION}.jar /opt/gateway/gateway.jar

CMD ["java", "-jar", "/opt/gateway/gateway.jar"]