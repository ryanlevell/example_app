package org.levell.example_app.spec.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DashboardUI {

    static final String STAGING_URI = "https://spring-moon-2764.fly.dev/dashboard/home";

    public String getSampleText() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate(STAGING_URI);
            return page.getByText("Hello thymeleaf!").textContent();
        }
    }

    public String get_version_displayed() {
//        open(STAGING_URI + "/dashboard/home");
//        return $(".staging .version").text().equals(version);
//
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch();
//            Page page = browser.newPage();
//            page.navigate("http://playwright.dev");
//            System.out.println(page.title());
//        }

        return "";
    }
}
