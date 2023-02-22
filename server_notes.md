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
flyctl secrets set SPRING_SECURITY_USER_NAME=user --config ./deploy/fly.production.toml
flyctl secrets set SPRING_SECURITY_USER_PASSWORD=password --config ./deploy/fly.production.toml
```

#### Deploy to Fly.io
```
flyctl launch # to set up initial fly.toml
fltctl deploy # to deploy using existing fly.toml
```

# Debug Github Webhook for Jenkins
https://stackoverflow.com/a/60625199

# Install Docker
https://docs.docker.com/engine/install/ubuntu/#install-using-the-repository

### Add jenkins user to use docker without sudo  
Fixes `Error connecting to local docker daemon: Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock`:

```
sudo groupadd docker
sudo usermod -aG docker jenkins

sudo systemctl daemon-reload
sudo systemctl restart docker
sudo service jenkins restart
```

### Add Docker agent to Jenkins
- Install 2 plugins: Docker plugin and Docker Pipeline.
- Go to Jenkins root page > Manage Jenkins > Manage Plugins > Available and search for the plugins.

### Install Docker Chrome for Browser (Selenium) Testing
```
sudo docker run --rm -d -p 4444:4444 --shm-size=2g selenium/standalone-chrome
```

Add to surefire plugin:
```
<systemPropertyVariables>
  <selenide.remote>http://localhost:4444/wd/hub</selenide.remote>
</systemPropertyVariables>
```

# Unsolved Issues
- Running `flyctl` from both ubuntu user and jenkins user. Can only do one or the other without deleting fly* files in /tmp.
  - Also requires relogging into fly via `sudo su jenkins ; fly auth login`
