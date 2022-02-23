pipeline {
    agent any
    
        parameters {
        choice(choices: ['int','pre','bld'], description: 'Choose Environment to Run', name: 'ENV')
        string(name: 'BASE_URI', defaultValue: 'https://www.google.com', description: 'Environment specific base uri')
        string(name: 'NO_OF_USERS', defaultValue: '2', description: 'No of users')
    }
    
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
                sh 'mvn clean test -DBASE_URI=$BASE_URI'
                
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