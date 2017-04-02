package game.of.life

class BootStrap {

    def init = { servletContext ->

        initBlockPattern()
        initBoatPattern()
        initBlinkerPattern()
        initToadPattern()
    }
    def destroy = {
    }

    private initBlockPattern(){
        Pattern block=new Pattern(name: "block").save()
        Generation generationInitial=new Generation(step: 0)

        generationInitial.addToCells(new Cell(row: 1,col: 1,isAlive: true))
        generationInitial.addToCells(new Cell(row: 2,col: 1,isAlive: true))
        generationInitial.addToCells(new Cell(row: 1,col: 2,isAlive: true))
        generationInitial.addToCells(new Cell(row: 2,col: 2,isAlive: true))

        generationInitial.save()

        block.addToGenerations(generationInitial).save()
    }

    private initBoatPattern(){
        Pattern block=new Pattern(name: "boat").save()
        Generation generationInitial=new Generation(step: 0)

        generationInitial.addToCells(new Cell(row: 1,col: 1,isAlive: true))
        generationInitial.addToCells(new Cell(row: 1,col: 2,isAlive: true))
        generationInitial.addToCells(new Cell(row: 1,col: 3,isAlive: false))
        generationInitial.addToCells(new Cell(row: 2,col: 1,isAlive: true))
        generationInitial.addToCells(new Cell(row: 2,col: 2,isAlive: false))
        generationInitial.addToCells(new Cell(row: 2,col: 3,isAlive: true))
        generationInitial.addToCells(new Cell(row: 3,col: 1,isAlive: false))
        generationInitial.addToCells(new Cell(row: 3,col: 2,isAlive: true))
        generationInitial.addToCells(new Cell(row: 3,col: 3,isAlive: false))

        generationInitial.save()

        block.addToGenerations(generationInitial).save()
    }

    private initBlinkerPattern(){
        Pattern block=new Pattern(name: "blinker").save()
        Generation generationInitial=new Generation(step: 0)

        generationInitial.addToCells(new Cell(row: 1,col: 1,isAlive: false))
        generationInitial.addToCells(new Cell(row: 1,col: 2,isAlive: true))
        generationInitial.addToCells(new Cell(row: 1,col: 3,isAlive: false))
        generationInitial.addToCells(new Cell(row: 2,col: 1,isAlive: false))
        generationInitial.addToCells(new Cell(row: 2,col: 2,isAlive: true))
        generationInitial.addToCells(new Cell(row: 2,col: 3,isAlive: false))
        generationInitial.addToCells(new Cell(row: 3,col: 1,isAlive: false))
        generationInitial.addToCells(new Cell(row: 3,col: 2,isAlive: true))
        generationInitial.addToCells(new Cell(row: 3,col: 3,isAlive: false))

        generationInitial.save()

        block.addToGenerations(generationInitial).save()
    }

    private initToadPattern(){
        Pattern block=new Pattern(name: "toad").save()
        Generation generationInitial=new Generation(step: 0)

        generationInitial.addToCells(new Cell(row: 1,col: 1,isAlive: false))
        generationInitial.addToCells(new Cell(row: 1,col: 2,isAlive: true))
        generationInitial.addToCells(new Cell(row: 1,col: 3,isAlive: true))
        generationInitial.addToCells(new Cell(row: 1,col: 4,isAlive: true))
        generationInitial.addToCells(new Cell(row: 2,col: 1,isAlive: true))
        generationInitial.addToCells(new Cell(row: 2,col: 2,isAlive: true))
        generationInitial.addToCells(new Cell(row: 2,col: 3,isAlive: true))
        generationInitial.addToCells(new Cell(row: 2,col: 4,isAlive: false))

        generationInitial.save()

        block.addToGenerations(generationInitial).save()
    }
}
