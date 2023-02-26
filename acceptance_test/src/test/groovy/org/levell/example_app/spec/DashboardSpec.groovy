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
        dashboardUI.getSampleText() == "Hello thymeleaf!"
    }

    @Ignore("WIP")
    def "Should display new version when a deployment candidate is created"() {

        when: "A new deployment candidate is created"
        deployApi.create_a_deployment_candidate("app1", "1.0.0", "staging", "", LocalDateTime.parse("2007-12-03T10:15:30"))

        then: "The new version is displayed in the deploy dashboard"
        dashboardUI.get_version_displayed() == "1.0.0"
    }
}