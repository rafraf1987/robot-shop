#!/usr/bin/env groovy

node {
	
	stage('SCM Checkout') {
		checkout scm
	}

	def dockerize  = load('./Jenkinsbuild.groovy')
 
        stage('Build'){
		
		withEnv([
			"IMAGE_NAME=${env.BRANCH.replace(' ','_').replace('-','_')}_build_${env.BUILD_NUMBER}",
		]) {
			dockerize.dockerizeServices(IMAGE_NAME)
			dockerize.pushImages(IMAGE_NAME)
		}
	    }
	}
