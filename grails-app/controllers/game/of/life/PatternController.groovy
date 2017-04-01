package game.of.life


import grails.rest.*

class PatternController extends RestfulController<Pattern>{
	static responseFormats = ['json']

    PatternController(){
        super(Pattern)
    }
}
