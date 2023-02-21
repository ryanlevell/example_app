package org.levell.example_app.spec.steps;

import io.restassured.RestAssured;

import java.time.LocalDateTime;

import static java.lang.String.format;

public class DeployApi {

    static final String STAGING_URI = "https://spring-moon-2764.fly.dev";

    public String create_a_new_deployment(String appName, String appVersion, String appEnvironment, String buildNumber, LocalDateTime buildTime) {
//        return "";
        return RestAssured.given()
                .baseUri(STAGING_URI)
                .body(format("""
                        {
                          "build_number": "%s",
                          "build_time": "%s",
                          "app_name": "%s",
                          "app_version": "%s",
                          "app_environment": "%s"
                        }
                        """, buildNumber, buildTime, appName, appVersion, appEnvironment))
                .post("api/deployment")
                .body()
                .asPrettyString();
    }
}
