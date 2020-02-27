FROM jenkins/jenkins

RUN /usr/local/bin/install-plugins.sh blueocean
COPY build/libs/environment-variable-page-decoration.jpi /usr/share/jenkins/ref/plugins/
