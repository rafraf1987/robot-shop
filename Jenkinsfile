node {
       
            stage('clone repository') {
                    echo 'clone repository'
                    git 'https://github.com/rafraf1987/robot-shop'
                 
                }    
                  
            stage('Build image') {
                        echo 'Starting to build docker images'
                        def cart = docker.build("cart-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/cart/Dockerfile ./cart")
                        def catalogue = docker.build("catalogue-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/catalogue/Dockerfile ./cataloige") 
                        def mongo = docker.build("mongo-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/mongo/Dockerfile ./mongo") 
                        def mysql = docker.build("mysql-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/mysql/Dockerfile ./mysql")
                        def payment = docker.build("payment-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/payment/Dockerfile ./payment") 
                        def shiping = docker.build("shiping-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/shiping/Dockerfile ./shiping") 
                        def user = docker.build("user-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/user/Dockerfile ./user")
                        def web = docker.build("web-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/web/Dockerfile ./web")
                    }

            stage('Push image') {
                   echo 'Trying to Push Docker Build to DockerHub'
                   docker.withRegistry('https://registry.hub.docker.com', 'docker_hub') {
                     cart.push("${env.BUILD_NUMBER}")
                     cart.push("latest")
                    
                }
            }
        }
