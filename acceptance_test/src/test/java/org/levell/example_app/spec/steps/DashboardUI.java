package org.levell.example_app.spec.steps;

import com.microsoft.playwright.*;
import org.levell.example_app.config.Config;

public class DashboardUI {

    static Config config = new Config();
    Playwright playwright = Playwright.create();
    Page page;

    public void login() {
        getPage().locator("#username").fill("user");
        getPage().locator("#password").fill("password");
        getPage().locator("[type='submit']").click();
        getPage().waitForSelector("h1");
    }

    public String get_sample_text() {
        getPage().navigate(config.getBaseUri() + "/dashboard/home");

        if(!isLoggedIn()) {
            login();
        }

        return getPage().getByText("Hello user!").textContent();
    }

    private boolean isLoggedIn() {
        try {
            getPage().waitForSelector("#username", new Page.WaitForSelectorOptions().setTimeout(2500));
            return false;
        } catch(TimeoutError e) {
            return true;
        }
    }

    public String get_latest_release_version() {
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

    private Page getPage() {
        if(page == null) {
            page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(config.getBrowserHeadless())).newContext().newPage();
        }
        return page;
    }

    public void close() {
        playwright.close();
    }
}
