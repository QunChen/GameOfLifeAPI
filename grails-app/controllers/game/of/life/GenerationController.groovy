package game.of.life

import com.google.gson.Gson
import grails.rest.*
import grails.converters.*

class GenerationController extends RestfulController<Generation> {
    static responseFormats = ['json']

    def algorithmService

    GenerationController() {
        super(Generation)
    }

    def index() {

        if (params.patternId) {

            def pattern = Pattern.get(params.patternId)

            if (params.step) {
                def targetStepGeneration = Generation.findByPatternAndStep(
                        pattern, params.step)

                if (!targetStepGeneration) {

                    respond algorithmService.toStep( pattern,
                            params.int('step')).cells
                    return
                }else{
                    respond targetStepGeneration.cells
                    return
                }

            }


            respond Generation.findAllByPattern(pattern,["order":"id"])

            return

        } else {
            super.index(10)
        }

    }

}
