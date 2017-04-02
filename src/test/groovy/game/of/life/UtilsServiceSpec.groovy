package game.of.life

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UtilsService)
@Mock(Cell)
class UtilsServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test getBoundaries"() {
        given:
        def c1=new Cell(row:1,col:1)
        def c2=new Cell(row:1,col:2)
        def c3=new Cell(row:2,col:1)
        def c4=new Cell(row:2,col:2)

        def cells=[]
        cells<<c1
        cells<<c2
        cells<<c3
        cells<<c4

        when:"fix me"
        def result=service.getBoundaries(cells)

        then:
        result[0]==1
        result[1]==2
        result[2]==1
        result[3]==2
    }
}
