package org.levell.example_app.spec

import org.levell.example_app.spec.steps.DashboardUI
import org.levell.example_app.spec.steps.DeployApi
import spock.lang.Ignore
import spock.lang.Specification

import java.time.LocalDateTime

class DashboardSpec extends Specification {

    def deployApi = new DeployApi()
    def dashboardUI = new DashboardUI()

    def "Should show sample text when page is opened"() {
        expect:
        dashboardUI.get_sample_text() == "Hello user!"
    }

    @Ignore("WIP")
    def "Should display new version when a deployment candidate is created"() {
        given: "A logged in user"
        dashboardUI.login()

        when: "A new deployment candidate is created"
        deployApi.create_release_candidate("app1", "1.0.0", "", LocalDateTime.parse("2007-12-03T10:15:30"))

        then: "The new version is displayed in the deploy dashboard"
        dashboardUI.get_latest_release_version() == "1.0.0"
    }

    def cleanup() {
        dashboardUI.close();
    }
}