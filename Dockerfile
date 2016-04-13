FROM 814633283276.dkr.ecr.us-east-1.amazonaws.com/tomcat:8-jdk8

MAINTAINER I Will Not Maintain This <leave@me.alone>

ENV ROOT_WAR_PATH /usr/local/tomcat/webapps/ROOT.war

WORKDIR /usr/local

USER root

COPY ./build/libs/*.war $ROOT_WAR_PATH

USER tomcat
