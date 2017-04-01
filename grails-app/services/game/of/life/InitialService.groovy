package game.of.life

import grails.transaction.Transactional

@Transactional
class InitialService {

    def initialNext(generation,pattern){
        def cells=generation.cells

        def maxRow=cells.max{
            it.row
        }.row

        def minRow=cells.min{
            it.row
        }.row

        def maxCol=cells.max{
            it.col
        }.col

        def minCol=cells.min{
            it.col
        }.col

        def nextGeneration=new Generation(step: generation.step+1,pattern:pattern).save()

        generation.cells.each{
            nextGeneration.addToCells(new Cell(row:it.row,col:it.col,isAlive: it.isAlive))
        }

        nextGeneration.addToCells(new Cell(row:minRow-1,col:minCol-1,isAlive: false))
        nextGeneration.addToCells(new Cell(row:minRow-1,col:maxCol+1,isAlive: false))
        nextGeneration.addToCells(new Cell(row:maxRow+1,col:minCol-1,isAlive: false))
        nextGeneration.addToCells(new Cell(row:maxRow+1,col:maxCol+1,isAlive: false))

        (minCol..maxCol).each{
            nextGeneration.addToCells(new Cell(row:minRow-1,col:it,isAlive: false))
            nextGeneration.addToCells(new Cell(row:maxRow+1,col:it,isAlive: false))
        }

        (minRow..maxRow).each{
            nextGeneration.addToCells(new Cell(row:it,col:minCol-1,isAlive: false))
            nextGeneration.addToCells(new Cell(row:it,col:maxCol+1,isAlive: false))
        }

        nextGeneration.save()

        nextGeneration
    }

}
