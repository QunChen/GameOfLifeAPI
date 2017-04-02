package game.of.life


import grails.test.mixin.integration.Integration
import grails.transaction.*
import static grails.web.http.HttpHeaders.*
import static org.springframework.http.HttpStatus.*
import spock.lang.*
import geb.spock.*
import grails.plugins.rest.client.RestBuilder

@Integration
@Rollback
class AppSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Test the homepage"() {
        when:"The home page is requested"
            def resp = restBuilder().get("$baseUrl/")

        then:"The response is correct"
            resp.status == OK.value()
            resp.headers[CONTENT_TYPE] == ['application/json;charset=UTF-8']
            resp.json.message == 'Welcome to Grails!'
    }

    void "Test the pattern endpoint - list service"() {
        when:"The /patterns is requested"
        def resp = restBuilder().get("$baseUrl/patterns")

        then:"The response is correct"
        resp.status == OK.value()
        resp.headers[CONTENT_TYPE] == ['application/json;charset=UTF-8']
        resp.text == '[{"id":1,"generations":[{"id":1}],"name":"block"},{"id":2,"generations":[{"id":2}],"name":"boat"},{"id":3,"generations":[{"id":3}],"name":"blinker"},{"id":4,"generations":[{"id":4}],"name":"toad"}]'
    }

    void "Test the pattern endpoint - show service"() {
        when:"The /patterns/{id} is requested"
        def resp = restBuilder().get("$baseUrl/patterns/1")

        then:"The response is correct"
        resp.status == OK.value()
        resp.headers[CONTENT_TYPE] == ['application/json;charset=UTF-8']
        resp.text == '{"id":1,"generations":[{"id":1}],"name":"block"}'
    }

    void "Test the nested generation endpoint - show service with step"() {
        when: "The patterns/{id}/generations?step=0 is requested"
        def resp = restBuilder().get("$baseUrl/patterns/1/generations?step=0")

        then: "The response is correct"
        resp.status == OK.value()
        resp.headers[CONTENT_TYPE] == ['application/json;charset=UTF-8']
        resp.text == '[{"id":1,"col":1,"generation":{"id":1},"isAlive":true,"row":1},{"id":2,"col":1,"generation":{"id":1},"isAlive":true,"row":2},{"id":3,"col":2,"generation":{"id":1},"isAlive":true,"row":1},{"id":4,"col":2,"generation":{"id":1},"isAlive":true,"row":2}]'
    }
    RestBuilder restBuilder() {
        new RestBuilder()
    }
}
