#!/usr/bin/groovy

DOCKER_IMAGE_REPOSITORY = 'rafraf1111'

ROBOT_SHOP_SERVICES = [
    "cart": "cart-image",
    "catalogue": "catalogue-image",
    "mongo": "mongo-image",
    "mysql": "mysql-image",
    "payment": "payment-image",
    "shipping": "shipping-image",
    "user": "user-image",
    "web": "web-image",
]

def dockerizeServices(version){
    withEnv([
        "VERSION=${version}",
    ]) {

        stage ("Building Docker Images"){
             docker.withRegistry('https://registry.hub.docker.com','docker_hub') {
                /* groovylint-disable-next-line NoDef, VariableTypeRequired */
                tasks = [:]

                ROBOT_SHOP_SERVICES.each { entry ->

                    println "Name: $entry.key image: $entry.value"
                    tasks["$entry.value"] = {
                            /* groovylint-disable-next-line NestedBlockDepth */
                            dir("$entry.key") {
                                sh "docker build -t ${DOCKER_IMAGE_REPOSITORY}/$entry.value:${VERSION}"
                            }
                        }
                    }
                }
                parallel tasks
            }
        }
    }


def pushImages(version, boolean removeImages = true){
    withEnv([
        "VERSION=${version}",
    ]) {
        docker.withRegistry('https://registry.hub.docker.com','docker_hub' {
            stage ("Pushing Docker Images"){
                def tasks = [:]

                ROBOT_SHOP_SERVICES.each { entry ->
                    println "Name: $entry.key image: $entry.value"

                    tasks["$entry.value"] = {
                            /* groovylint-disable-next-line NestedBlockDepth */
                            dir("$entry.key") {
                                sh "docker push ${DOCKER_IMAGE_REPOSITORY}/$entry.value:${VERSION}"
                                /* groovylint-disable-next-line NestedBlockDepth */
                                if (removeImages == true) {
                                    sh "docker rmi ${DOCKER_IMAGE_REPOSITORY}/$entry.value:${VERSION}"
                                }
                                sh ""
                            }
                        }
                    }
                }
                parallel tasks
            }
        )
    }
}
return this