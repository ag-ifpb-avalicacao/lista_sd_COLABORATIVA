#!/bin/bash

curl "localhost:9090/Monitor?wsdl" --output monitor.wsdl
sleep 2
mv monitor.wsdl src/main/java/
cd src/main/java/
wsimport monitor.wsdl -Xnocompile
