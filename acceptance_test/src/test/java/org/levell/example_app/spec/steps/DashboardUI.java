package org.levell.example_app.spec.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.levell.example_app.config.Config;

public class DashboardUI {

    static Config config = new Config();
    Playwright playwright = Playwright.create();
    Browser browser;

    public String getSampleText() {
        Page page = getBrowser().newPage();
        page.navigate(config.getBaseUri());
        page.locator("#username").fill("user");
        page.locator("#password").fill("password");
        page.locator("[type='submit']").click();
        return page.getByText("Hello user!").textContent();
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

    private Browser getBrowser() {
        if(browser == null) {
            browser = playwright.chromium().launch();
        }
        return browser;
    }

    public void close() {
        playwright.close();
    }
}
