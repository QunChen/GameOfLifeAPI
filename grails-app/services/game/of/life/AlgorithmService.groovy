package game.of.life

import grails.transaction.Transactional

@Transactional
class AlgorithmService {


    def neighbourService
    def initialService
    def statusService
    def trimService

    def next(generation,pattern){

        def nextGeneration = initialService.initialNext(generation,pattern)

        nextGeneration.cells.each{
            it.isAlive=statusService.calculateStatus(neighbourService.getNoOfAlives(it,generation),it)
            it.save()
        }

        trimService.trim(nextGeneration)

        nextGeneration
    }
}
