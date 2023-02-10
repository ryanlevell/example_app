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

### View active deployments
As an application stakeholder
I want to view the deployed versions of the application
So that I know what version and features are available