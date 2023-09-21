FROM ibm-semeru-runtimes:open-17-jre
RUN apt-get update && \
    apt-get install -y gettext \
                       tzdata

COPY entrypoint.sh /
RUN chmod +x entrypoint.sh

COPY configtemplates  /configtemplates
RUN mkdir /app

ADD /maven/web-exec.jar /app/web.jar

WORKDIR /app

ENTRYPOINT [ "/entrypoint.sh" ]