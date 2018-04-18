#!/bin/bash

curl "localhost:9091/WSUser?wsdl" --output user.wsdl
sleep 2
mv user.wsdl src/main/java/
cd src/main/java/
wsimport user.wsdl -Xnocompile
