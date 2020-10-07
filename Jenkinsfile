#!/usr/bin/env groovy

node {

	stage('Environment Setup') {
		if (env.BRANCH_NAME=='master'){
			properties([
				buildDiscarder(logRotator(numToKeepStr: '30')),
			])
			SKIP_TESTS = "true"
		} else {
			properties([
				buildDiscarder(logRotator(numToKeepStr: '3')),
				parameters([booleanParam(name: 'SKIP_TESTS', defaultValue: false, description: 'Skip test for quick build')])
			])
			SKIP_TESTS = "${params.SKIP_TESTS}"
		}
		echo "Building and Dockerizing Branch ${env.BRANCH_NAME} No. ${env.BUILD_NUMBER} in Workspace ${env.WORKSPACE}"
		slackSend (color: '#FFFF00', message: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
	}
    

	stage('SCM Checkout') {
		checkout scm
	}


	def dockerize  = load('build/dockerize.groovy')



		withEnv([
			"IMAGE_NAME=${env.BRANCH_NAME.replace('@','_').replace(' ','_').replace('-','_')}_build_${env.BUILD_NUMBER}",
		]) {
			dockerize.dockerizeServices(IMAGE_NAME)
			dockerize.pushImages(IMAGE_NAME)
		}
	}  

