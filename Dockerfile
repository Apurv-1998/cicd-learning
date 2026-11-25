FROM eclipse-temurin:17-jre
WORKDIR /app
ARG GIT_COMMIT=unknown
LABEL org.opencontainers.image.revision="${GIT_COMMIT}"
ENV APP_VERSION="${GIT_COMMIT}"
COPY target/cicd-demo.jar /app/app.jar
USER 10001
EXPOSE 8080
ENTRYPOINT [ "java","-jar","/app/app.jar" ]