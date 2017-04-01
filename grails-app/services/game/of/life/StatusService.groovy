package game.of.life

import grails.transaction.Transactional

@Transactional
class StatusService {




    def calculateStatus(aliveNeighbours,cell) {
        if (aliveNeighbours<2||aliveNeighbours>3){
            false
        }else if(aliveNeighbours==3){
            true
        }else if(aliveNeighbours==2){
            cell.isAlive
        }
    }
}
