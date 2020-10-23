#!/usr/bin/env groovy

node {



	stage('SCM Checkout') {
		checkout scm
	}

	def dockerize  = load('./Jenkinsbuild.groovy')

    stage('Build'){
        
			dockerize.dockerizeServices
			dockerize.pushImages
		}
		
	}
