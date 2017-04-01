package game.of.life

class UrlMappings {

    static mappings = {

        "/generations"(resources:"generation"){

        }

        "/patterns"(resources:"pattern"){
            "/generations"(resources:"generation")
        }

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
