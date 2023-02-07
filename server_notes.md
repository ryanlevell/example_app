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

\* Add to /etc/environment:
```
FLYCTL_INSTALL="/home/ubuntu/.fly"
PATH="$FLYCTL_INSTALL/bin:$PATH"
```
```
. /etc/environment
```

# DEBUG GITHUB WEBHOOK FOR JENKINS
https://stackoverflow.com/a/60625199


