pipeline {

    agent any

    stages {

        stage("Build") {
            steps {
                echo 'Building project....'
                bash '/usr/local/sbtDownload/sbt/bin/sbt compile'
            }
        }

        stage("Test") {
            steps {
                echo 'Testing project....'
                bash '/usr/local/sbtDownload/sbt/bin/sbt test'
            }
        }
    }
}