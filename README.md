# example_app

# Prerequisites

### Maven Wrapper (only needed once)
Run `mvn wrapper:wrapper` to get started with `./mvnw`

### Add to server's environment variables (and also as Jenkins credentials)
`SPRING_SECURITY_USER_NAME`  
`SPRING_SECURITY_USER_PASSWORD`

# Running

### Local
In IntelliJ add `Edit Configurations > Add VM Options` => `-Dspring.profiles.active=local`

# QoL TODOs
- Added `fmt:format` plugin and pre-commit hook `fmt:check`

# Features

### Deploy a new version
As a user of example_app
I want a new version to be deployed
So that I can use the newest features

### View active deployments
As a user of example_app
I want the deployed versions to be viewable
So that I know what features are available

