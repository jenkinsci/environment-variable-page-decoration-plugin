FROM jenkins/jenkins

COPY build/libs/environment-variable-page-decoration.jpi /usr/share/jenkins/ref/plugins/
