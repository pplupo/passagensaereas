#! /bin/bash

if [ -z $JAVA_HOME ]; then
    echo "JAVA_HOME is not set!"
    exit -1
fi

WHICH=`which which`
PATH="$JAVA_HOME/bin"

if ! $WHICH java 2>&1 > /dev/null; then
    echo "No java executable found in PATH"
    exit -1
fi

java -jar PassagensAereasCliente.jar
