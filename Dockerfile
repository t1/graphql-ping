FROM rdohna/wildfly

COPY pong ${JBOSS_HOME}/standalone/configuration/files/pong
COPY target/ping.war ${JBOSS_HOME}/standalone/deployments/ROOT.war
