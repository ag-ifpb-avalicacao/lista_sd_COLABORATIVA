#!/bin/bash

curl "localhost:9092/WSChat?wsdl" --output chat.wsdl
sleep 2
mv chat.wsdl src/main/java/
cd src/main/java/
wsimport chat.wsdl -Xnocompile
