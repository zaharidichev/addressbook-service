FROM java:8
MAINTAINER Zahari Dichev <zaharidichev@gmail.com>
VOLUME /tmp
ADD "target/scala-2.11/app.jar" app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar