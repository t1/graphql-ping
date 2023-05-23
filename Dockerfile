FROM rdohna/wildfly:27.0-jdk17-graphql

COPY target/ROOT.war ${JBOSS_HOME}/standalone/deployments/ROOT.war
