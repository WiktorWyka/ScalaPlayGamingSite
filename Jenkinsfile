pipeline {

    agent any

    stages {

        stage("Build") {
            steps {
                echo 'Building project....'
                '/usr/local/sbtDownload/sbt/bin/sbt compile'
            }
        }

        stage("Test") {
            steps {
                echo 'Testing project....'
                '/usr/local/sbtDownload/sbt/bin/sbt test'
            }
        }
    }
}