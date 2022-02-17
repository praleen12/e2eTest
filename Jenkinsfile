pipeline {
    agent any
    
        parameters {
        choice(choices: ['int','pre','bld'], description: 'Choose Environment to Run', name: 'ENV')
        string(name: 'BASE_URI', defaultValue: 'https://api.int01.if.e.lloydsbanking.com/ecomm/v1.0/auth', description: 'Environment specific base uri')
        string(name: 'NO_OF_USERS', defaultValue: '2', description: 'No of users')
        string(name: 'DURATION', defaultValue: '50', description: 'Load Duration')
        string(name: 'THINK_TIME', defaultValue: '1', description: 'User think time')
        choice(name: 'SCN_NAME', choices: ['Native Flow - Encrypted Payload', 'Native Flow - Un-encrypted Payload', 'Risk Call - Encrypted', 'Risk Call - Unencrypted', 'ACS Risk Call - Encrypted', 'ACS Risk Call - Unencrypted','Decryption Service'], description: 'Pick Scenario to run')
        choice(name: 'LOAD_TYPE', choices: ['Constant Concurrent Users', 'Constant Users per sec', 'Open Load Model'], description: 'Pick Load Type')
        string(name: 'ACCESS_TOKEN', defaultValue: '', description: 'Enter generated access token')
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