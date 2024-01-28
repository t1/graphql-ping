FROM rdohna/wildfly:31.0-jdk17-graphql

COPY target/ROOT.war ${JBOSS_HOME}/standalone/deployments/ROOT.war
