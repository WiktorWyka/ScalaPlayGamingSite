pipeline {

    agent any

    stages {

        stage("Build") {
            steps {
                echo 'Building project....'
                sh '/usr/local/sbtDownload/sbt/bin/sbt compile'
            }
        }

        stage("Test") {
            steps {
                echo 'Testing project....'
                sh '/usr/local/sbtDownload/sbt/bin/sbt test'
            }
        }
    }
}