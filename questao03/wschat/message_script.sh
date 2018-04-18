#!/bin/bash

curl "localhost:9090/WSMessage?wsdl" --output message.wsdl
sleep 2
mv message.wsdl src/main/java/
cd src/main/java/
wsimport message.wsdl -Xnocompile
