package game.of.life


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class PatternSpec extends Specification {

    def algorithmService

    def setup() {
    }

    def cleanup() {
    }

    void "test block pattern next 1 generation"() {
        given:"get block pattern"
            def pattern = Pattern.findByName("block")

        when:"get next 1 generation"
            def nextGeneration=algorithmService.toStep( pattern, 1)

        then:"""total number of cell is 4;the number of alive cell is 4; the number of dead cell is 0;each individual cell is correct"
            x   x   
            x   x   
            """
            nextGeneration.cells.size()==4
            nextGeneration.cells.count{it.isAlive} == 4
            nextGeneration.cells.count{!it.isAlive} == 0
            nextGeneration.cells.find{it.col==1&&it.row==1}.isAlive == true
            nextGeneration.cells.find{it.col==2&&it.row==1}.isAlive == true
            nextGeneration.cells.find{it.col==1&&it.row==2}.isAlive == true
            nextGeneration.cells.find{it.col==2&&it.row==2}.isAlive == true

    }

    void "test block pattern next multiple generation"() {
        given:"get block pattern"
        def pattern = Pattern.findByName("block")

        when:"get next 2 generation"
        def nextGeneration=algorithmService.toStep( pattern, 2)

        then:"""total number of cell is 4;the number of alive cell is 4; the number of dead cell is 0;each individual cell is correct"
            x   x   
            x   x   
            """
        nextGeneration.cells.size()==4
        nextGeneration.cells.count{it.isAlive} == 4
        nextGeneration.cells.count{!it.isAlive} == 0
        nextGeneration.cells.find{it.col==1&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==2&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==1&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==2&&it.row==2}.isAlive == true

    }

    void "test boat pattern next 1 generation"() {
        given:"get boat pattern"
        def pattern = Pattern.findByName("boat")

        when:"get next 1 generation"
        def nextGeneration=algorithmService.toStep( pattern, 1)

        then:"""total number of cell is 9;the number of alive cell is 5; the number of dead cell is 4;each individual cell is correct"
        x   x   -
        x   -   x
        -   x   -
        """
        nextGeneration.cells.size()==9
        nextGeneration.cells.count{it.isAlive} == 5
        nextGeneration.cells.count{!it.isAlive} == 4
        nextGeneration.cells.find{it.col==1&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==2&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==1}.isAlive == false
        nextGeneration.cells.find{it.col==1&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==2&&it.row==2}.isAlive == false
        nextGeneration.cells.find{it.col==3&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==1&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==3}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==3}.isAlive == false
    }

    void "test boat pattern next multiple generation"() {
        given:"get boat pattern"
        def pattern = Pattern.findByName("boat")

        when:"get next 2 generation"
        def nextGeneration=algorithmService.toStep( pattern, 2)

        then:"""total number of cell is 9;the number of alive cell is 5; the number of dead cell is 4;each individual cell is correct"
        x   x   -
        x   -   x
        -   x   -
        """
        nextGeneration.cells.size()==9
        nextGeneration.cells.count{it.isAlive} == 5
        nextGeneration.cells.count{!it.isAlive} == 4
        nextGeneration.cells.find{it.col==1&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==2&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==1}.isAlive == false
        nextGeneration.cells.find{it.col==1&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==2&&it.row==2}.isAlive == false
        nextGeneration.cells.find{it.col==3&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==1&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==3}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==3}.isAlive == false
    }

    void "test blinker pattern next 1 generation"() {
        given:"get blinker pattern"
        def pattern = Pattern.findByName("blinker")

        when:"get next generation"
        def nextGeneration=algorithmService.toStep( pattern, 1)

        then:"""total number of cell is 9;the number of alive cell is 3; the number of dead cell is 6;each individual cell is correct"
        -   -   -
        x   x   x
        -   -   -
        """
        nextGeneration.cells.size()==9
        nextGeneration.cells.count{it.isAlive} == 3
        nextGeneration.cells.count{!it.isAlive} == 6
        nextGeneration.cells.find{it.col==1&&it.row==1}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==1}.isAlive == false
        nextGeneration.cells.find{it.col==3&&it.row==1}.isAlive == false
        nextGeneration.cells.find{it.col==1&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==2&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==1&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==3&&it.row==3}.isAlive == false
    }

    void "test blinker pattern next multiple generation"() {
        given:"get blinker pattern"
        def pattern = Pattern.findByName("blinker")

        when:"get next generation"
        def nextGeneration=algorithmService.toStep( pattern, 2)

        then:"""total number of cell is 9;the number of alive cell is 3; the number of dead cell is 6;each individual cell is correct"
        -   x   -
        -   x   -
        -   x   -
        """
        nextGeneration.cells.size()==9
        nextGeneration.cells.count{it.isAlive} == 3
        nextGeneration.cells.count{!it.isAlive} == 6
        nextGeneration.cells.find{it.col==1&&it.row==1}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==1}.isAlive == false
        nextGeneration.cells.find{it.col==1&&it.row==2}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==2}.isAlive == false
        nextGeneration.cells.find{it.col==1&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==3}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==3}.isAlive == false
    }

    void "test toad pattern next 1 generation"() {
        given:"get toad pattern"
        def pattern = Pattern.findByName("toad")

        when:"get next 1 generation"
        def nextGeneration=algorithmService.toStep( pattern, 1)

        then:"""total number of cell is 16;the number of alive cell is 6; the number of dead cell is 10;each individual cell is correct as
        -   -   x   -
        x   -   -   x
        x   -   -   x
        -   x   -   -
                """
        nextGeneration.cells.size()==16
        nextGeneration.cells.count{it.isAlive} == 6
        nextGeneration.cells.count{!it.isAlive} == 10
        nextGeneration.cells.find{it.col==1&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==2&&it.row==1}.isAlive == false
        nextGeneration.cells.find{it.col==3&&it.row==1}.isAlive == false
        nextGeneration.cells.find{it.col==4&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==1&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==2&&it.row==2}.isAlive == false
        nextGeneration.cells.find{it.col==3&&it.row==2}.isAlive == false
        nextGeneration.cells.find{it.col==4&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==1&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==3}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==4&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==1&&it.row==0}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==0}.isAlive == false
        nextGeneration.cells.find{it.col==3&&it.row==0}.isAlive == true
        nextGeneration.cells.find{it.col==4&&it.row==0}.isAlive == false
    }

    void "test toad pattern next multiple generation"() {
        given:"get toad pattern"
        def pattern = Pattern.findByName("toad")

        when:"get next 2 generation"
        def nextGeneration=algorithmService.toStep( pattern, 2)

        then:"""total number of cell is 16;the number of alive cell is 6; the number of dead cell is 10;each individual cell is correct as
        -   -   -   -
        -   x   x   x
        x   x   x   -
        -   -   -   -
                """
        nextGeneration.cells.size()==16
        nextGeneration.cells.count{it.isAlive} == 6
        nextGeneration.cells.count{!it.isAlive} == 10
        nextGeneration.cells.find{it.col==1&&it.row==1}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==4&&it.row==1}.isAlive == true
        nextGeneration.cells.find{it.col==1&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==2&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==3&&it.row==2}.isAlive == true
        nextGeneration.cells.find{it.col==4&&it.row==2}.isAlive == false
        nextGeneration.cells.find{it.col==1&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==3&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==4&&it.row==3}.isAlive == false
        nextGeneration.cells.find{it.col==1&&it.row==0}.isAlive == false
        nextGeneration.cells.find{it.col==2&&it.row==0}.isAlive == false
        nextGeneration.cells.find{it.col==3&&it.row==0}.isAlive == false
        nextGeneration.cells.find{it.col==4&&it.row==0}.isAlive == false
    }
}
