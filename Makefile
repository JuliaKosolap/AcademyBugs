get-maven:
	mkdir -p utilities
	curl -O -k https://downloads.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.tar.gz
	tar -xzf apache-maven-3.9.4-bin.tar.gz -C utilities/
get-allure:
	curl -o allure-2.24.0.tgz -OLs https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.24.0/allure-commandline-2.24.0.tgz
	tar -xzf allure-2.24.0.tgz -C utilities/
check-versions:
	mvn -version
	allure --version
start-selenium-interactive:
	docker run -p 4444:4444 --shm-size=2g selenium/standalone-chrome:3.141.59-20210607
selenium-hub-interactive:
	docker-compose up
test:
	mvn clean test
test-results:
	allure serve allure-results
