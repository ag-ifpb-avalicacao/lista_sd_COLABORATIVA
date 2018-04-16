mvn clean install
sudo docker stop server
sudo docker rm server
sudo docker rmi questao2/server
sudo docker build -t questao2/server .
sudo docker run -p 8080:8080 --name server questao2/server
