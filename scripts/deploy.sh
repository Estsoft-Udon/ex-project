#!/bin/bash

LOG_FILE="/home/ec2-user/action/spring-deploy.log"
ERROR_LOG_FILE="/home/ec2-user/action/spring-deploy_err.log"

# 로그 파일에 시작 시각 기록
echo "## Deployment started at $(date)" >> $LOG_FILE

BUILD_JAR=$(ls /home/ec2-user/action/build/libs/*SNAPSHOT.jar)
if [ $? -ne 0 ]; then
  echo "## ERROR: Failed to find the build JAR file" >> $ERROR_LOG_FILE
  exit 1
fi
JAR_NAME=$(basename $BUILD_JAR)
echo "## build file name : $JAR_NAME" >> $LOG_FILE

echo "## copy build file" >> $LOG_FILE
DEPLOY_PATH=/home/ec2-user/action/
cp $BUILD_JAR $DEPLOY_PATH
if [ $? -ne 0 ]; then
  echo "## ERROR: Failed to copy the build file" >> $ERROR_LOG_FILE
  exit 1
fi

echo "## current pid" >> $LOG_FILE
CURRENT_PID=$(ps -ef | grep "java" | awk 'NR==1 {print $2}')
if [ $? -ne 0 ]; then
  echo "## ERROR: Failed to get current PID" >> $ERROR_LOG_FILE
  exit 1
fi

if [ -z $CURRENT_PID ]; then
  echo "## 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다." >> $LOG_FILE
else
  echo "## kill -15 $CURRENT_PID" >> $LOG_FILE
  kill -15 $CURRENT_PID
  if [ $? -ne 0 ]; then
    echo "## ERROR: Failed to kill the process with PID $CURRENT_PID" >> $ERROR_LOG_FILE
    exit 1
  fi
  sleep 5
fi

DEPLOY_JAR=$DEPLOY_PATH$JAR_NAME
echo "## deploy JAR file" >> $LOG_FILE
nohup java -jar $DEPLOY_JAR >> $LOG_FILE 2>> $ERROR_LOG_FILE &
if [ $? -ne 0 ]; then
  echo "## ERROR: Failed to start the JAR file" >> $ERROR_LOG_FILE
  exit 1
fi

echo "## Deployment finished at $(date)" >> $LOG_FILE
