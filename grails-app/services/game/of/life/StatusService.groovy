package game.of.life

import grails.transaction.Transactional

@Transactional
class StatusService {

    def neighbourService
    def initialService

    def next(generation){

        def nextGeneration = initialService.initialNext(generation)

        nextGeneration.cells.each{
            it.isAlive=calculateStatus(neighbourService.getNoOfAlives(it,generation))
            it.save()
        }

        nextGeneration
    }



    def calculateStatus(aliveNeighbours) {
        if (aliveNeighbours<2||aliveNeighbours>3){
            false
        }else if(aliveNeighbours==3){
            true
        }
    }
}
