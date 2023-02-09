import spock.lang.Specification

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open

class TestSpec extends Specification {

    def "a test spec"() {
        expect:
        2 + 2 == 4
    }

    def "a browser test"() {
        when:
        open("https://spring-moon-2764.fly.dev/dashboard/home")

        then:
        $("h1").text() == "Hello thymeleaf!"
    }
}