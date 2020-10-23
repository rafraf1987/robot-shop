#!/usr/bin/env groovy

node {
	
	stage('SCM Checkout') {
		checkout scm
	}

	def dockerize  = load('./Jenkinsbuild.groovy')
 
        stage('Build'){
        
	         dockerize.dockerizeServices("${env.WORKSPACE}")
	         dockerize.pushImages("${env.WORKSPACE}")
		}
		
	}
