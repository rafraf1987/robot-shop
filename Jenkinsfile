 pipeline {
        agent any
       
        stages {
            stage('clone repository') {
                steps {
                     echo 'clone repository'
                     git 'https://github.com/rafraf1987/robot-shop'
                     
                    }
                    
            stage('Build image') {
                steps {
                    echo 'Starting to build docker images'
                    script {
                        def cart = docker.build("my-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/cart/Dockerfile .")
                        def catalogue = docker.build("my-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/catalogue/Dockerfile .") 
                        def mongo = docker.build("my-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/mongo/Dockerfile .") 
                        def mysql = docker.build("my-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/mysql/Dockerfile .")
                        def payment = docker.build("my-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/payment/Dockerfile .") 
                        def shiping = docker.build("my-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/shiping/Dockerfile .") 
                        def user = docker.build("my-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/user/Dockerfile .")
                        def web = docker.build("my-image:${env.BUILD_ID}","-f ${env.WORKSPACE}/web/Dockerfile .")
                    }
                    

<<<<<<< HEAD
            stage('Push image') {
                steps {     
                   echo "Trying to Push Docker Build to DockerHub"
                   docker.withRegistry('https://registry.hub.docker.com', 'docker_hub') {
                   cart.push("${env.BUILD_NUMBER}")
                   }
                }
            }
        }
    }

=======
    stage('Clone repository') {
        /* Cloning the Repository to our Workspace */

        git 'https://github.com/rafraf1987/robot-shop'
    }
    
    stage('workdir') {
        
        dir ('/robot-shop/tree/devops/cart') {
    }
        
    stage('build image') {
            
        docker.build("rafraf1111/cart:${env.BUILD_NUMBER}")
    }
   
    stage('Test image') {
        
        cart.inside {
            echo "Tests passed"
        }
    }

    stage('Push image') {
        /* 
            You would need to first register with DockerHub before you can push images to your account
        */
        docker.withRegistry('https://registry.hub.docker.com', 'docker_hub') {
            cart.push("${env.BUILD_NUMBER}")
            } 
                echo "Trying to Push Docker Build to DockerHub"
        }
    }
}   
>>>>>>> 9660c82a8d83ba3ab44b7296c5897e8c75e5cdba
