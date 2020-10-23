#!/usr/bin/env groovy

node {

IMAGE_NAME = "${env.BRANCH_NAME.replace('@','_').replace(' ','_').replace('-','_')}_build_${env.BUILD_NUMBER}"

	stage('SCM Checkout') {
		checkout scm
	}

	def dockerize  = load('./Jenkinsbuild.groovy')
 
    stage('Build'){
        
			dockerize.dockerizeServices(IMAGE_NAME)
			dockerize.pushImages(IMAGE_NAME)
		}
		
	}
