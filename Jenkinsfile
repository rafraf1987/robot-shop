#!/usr/bin/env groovy

node {



	stage('SCM Checkout') {
		checkout scm
	}

	def dockerize  = load('./Jenkinsbuild.groovy')

    stage('Build'){
        
			dockerize.dockerizeServices(IMAGE_NAME)
			dockerize.pushImages(IMAGE_NAME)
		}
		
	}
