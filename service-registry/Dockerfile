FROM amazoncorretto:17-alpine-full

# Create user and group to downgrade privileges
RUN addgroup -S coreapp && adduser -S coreapp -G coreapp
USER coreapp:coreapp

# RabbitMQ connection
ENV MQ_URL=rabbit \
    MQ_USER="" \
    MQ_PASSWORD=""

# Registry configuration
ENV EUREKA_HOSTNAME=0.0.0.0
ENV APP_PORT=8090

# Expose configured port
EXPOSE $APP_PORT

STOPSIGNAL SIGKILL

WORKDIR /var/lib/application

ADD ./target/app.jar .

CMD java -jar /var/lib/application/app.jar

HEALTHCHECK --interval=30s --timeout=2s --retries=5 --start-period=40s \
  CMD curl --fail --silent localhost:8081/actuator/health | grep UP || exit 1