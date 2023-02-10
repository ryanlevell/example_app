package org.levell.example_app.spec

import org.levell.example_app.spec.steps.DashboardUI
import org.levell.example_app.spec.steps.DeployApi
import spock.lang.Ignore
import spock.lang.Specification

class DashboardSpec extends Specification {

    def deployApi = new DeployApi()
    def dashboardUI = new DashboardUI()

    @Ignore("WIP")
    def "Should display new version when application is deployed"() {
        when: "A new version is deployed"
        deployApi.create_new_deployment("1.0.0")

        then: "The new version is displayed in the deploy dashboard"
        dashboardUI.version_is_displayed("1.0.0")
    }
}