package game.of.life

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(InitialService)
@Mock([Cell,Generation,Pattern])
class InitialServiceSpec extends Specification {

    def setup() {
        def generation = new Generation()
    }

    def cleanup() {
    }

    void "test initialNext"() {
        given:"a basic 2*2 cells"
        def c1=new Cell(row:1,col:1)
        def c2=new Cell(row:1,col:2)
        def c3=new Cell(row:2,col:1)
        def c4=new Cell(row:2,col:2)

        def generation = new Generation(step: 0)
        generation.addToCells(c1)
        generation.addToCells(c2)
        generation.addToCells(c3)
        generation.addToCells(c4)

        def pattern =new Pattern(name:"test")
        pattern.addToGenerations(generation)

        def utilsService = Mock(UtilsService)
        utilsService.getBoundaries(_) >> {cells ->
            return [1,2,1,2]
        }
        service.utilsService=utilsService

        when:
            def nextGeneration=service.initialNext(generation,pattern)

        then:"step add 1, boundary cells are added"
            nextGeneration.step == 1
            nextGeneration.cells.size() == 16
    }
}
