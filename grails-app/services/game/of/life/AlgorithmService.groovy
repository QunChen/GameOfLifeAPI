package game.of.life

import grails.transaction.Transactional
import static groovyx.gpars.GParsPool.withPool

@Transactional
class AlgorithmService {


    def neighbourService
    def initialService
    def statusService
    def trimService

    /**
     * Calculate all generations between current and target
     * @param pattern
     * @param targetStep
     * @return generation in target step
     */
    def toStep(pattern,targetStep){
        int currentStep=pattern.generations.max{
            it.step
        }.step

        def nextGeneration

        while(currentStep!=targetStep){
            nextGeneration=next(Generation.findByPatternAndStep(pattern,currentStep),pattern)
            currentStep++
        }

        nextGeneration
    }

    /**
     * generate next generation of cells
     * @param generation
     * @param pattern
     * @return
     */
    private def next(generation,pattern){

        def nextGeneration = initialService.initialNext(generation,pattern)

        nextGeneration.cells.each{ cell->
            cell.isAlive=statusService.
                        calculateStatus(neighbourService.getNoOfAlives(cell,generation),cell)
            cell.save()
        }

        trimService.trim(nextGeneration)

        nextGeneration
    }
}
