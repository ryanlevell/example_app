package org.levell.example_app.spec.steps;

import io.restassured.RestAssured;
import org.levell.example_app.config.Config;

import java.time.LocalDateTime;

import static java.lang.String.format;

public class DeployApi {

    static Config config = new Config();

    public String create_release_candidate(String appName, String appVersion, String appLocation, String buildNumber, LocalDateTime buildTime) {
        return RestAssured.given()
                .baseUri(config.getBaseUri())
                .body(format("""
                        {
                          "build_number": "%s",
                          "build_time": "%s",
                          "app_name": "%s",
                          "app_version": "%s",
                          "app_location": "%s"
                        }
                        """, buildNumber, buildTime, appName, appVersion, appLocation))
                .post("api/release")
                .body()
                .asPrettyString();
    }
}
