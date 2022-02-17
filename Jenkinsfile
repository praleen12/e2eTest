pipeline {
    agent any
    
    environment {
        PATH = "/Applications/apache-maven-3.6.1/bin:$PATH"
    }
 
    stages {
    

        stage ('git clone') {
            steps {
                git branch: 'master', url: 'https://github.com/praleen12/e2eTest.git'
            }
        }
          stage ('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        

      stage ('Cucumber Reports') {

            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/**/cucumber.json",
                    jsonReportDirectory: 'target'

            }

        }
        
        
    }
}