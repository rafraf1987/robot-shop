#!/usr/bin/env groovy

node {



	stage('SCM Checkout') {
		checkout scm
	}

	def dockerize  = load('./Jenkinsbuild.groovy')
	 
	
	stage('Build)'{
		dockerize.dockerizeServices(${env.BRANCH_NAME})
		dockerize.pushImages(${env.BRANCH_NAME})
        }

}
