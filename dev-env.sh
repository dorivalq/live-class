#!/bin/bash
eb init -p tomcat
eb create dev-env
cp /c/dev/config.yml .elasticbeanstalk/ 
eb deploy live-class
eb logs dev-env 
eb open
