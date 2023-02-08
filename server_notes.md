# INSTALL JDK 17
https://docs.azul.com/core/zulu-openjdk/install/debian


# INSTALL JENKINS ONTO UBUNTU
https://www.digitalocean.com/community/tutorials/how-to-install-jenkins-on-ubuntu-20-04:
- start: sudo systemctl start jenkins
- status: sudo systemctl status jenkins
- open port 8080 AWS

### MOVE KEY FROM LEGACY TRUSTED.GPG
https://itsfoss.com/key-is-stored-in-legacy-trusted-gpg/

### Enable TLS via Nginx*
https://computingforgeeks.com/configure-jenkins-behind-nginx-reverse-proxy-and-lets-encrypt-ssl/

\* Don't forget to update webhook in Github to new https domain.

### Install Fly.io CLI on Jenkins
https://fly.io/docs/speedrun/

\* Add fly.io `bin` to `/etc/environment`:
```
PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/home/ubuntu/.fly/bin"
```
```
. /etc/environment
```

#### Add Dockerfile for fly.io deployment
```
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

#### Set FLy.io secrets for Spring Security user
```
flyctl secrets set SPRING_SECURITY_USER_NAME=user
flyctl secrets set SPRING_SECURITY_USER_PASSWORD=password
```

#### Deploy to Fly.io
```
flyctl launch # to set up initial fly.toml
fltctl deploy # to deploy using existing fly.toml
```

# DEBUG GITHUB WEBHOOK FOR JENKINS
https://stackoverflow.com/a/60625199


