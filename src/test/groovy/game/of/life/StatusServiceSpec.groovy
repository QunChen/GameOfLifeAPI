package game.of.life

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(StatusService)
@Mock(Cell)
class StatusServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test the number of alive neighbours is less than 2"() {
        given:
            def cell = new Cell(isAlive: false)

        when:
            def status=service.calculateStatus(1,cell)
        then:
            status == false
    }

    void "test the number of alive neighbours is more than 3"() {
        given:
        def cell = new Cell(isAlive: false)

        when:
        def status=service.calculateStatus(4,cell)
        then:
        status == false
    }

    void "test the number of alive neighbours is 2 and status is unchanged"() {
        given:
        def cell1 = new Cell(isAlive: false)
        def cell2 = new Cell(isAlive: true)

        when:
        def status1=service.calculateStatus(2,cell1)
        def status2=service.calculateStatus(2,cell2)
        then:
        status1 == false
        status2 == true
    }

    void "test the number of alive neighbours is 3 and status is alive"() {
        given:
        def cell = new Cell(isAlive: false)

        when:
        def status=service.calculateStatus(3,cell)

        then:
        status == true
    }
}
