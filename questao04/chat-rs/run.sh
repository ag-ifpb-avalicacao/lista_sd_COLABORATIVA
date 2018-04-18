mvn clean install
sudo docker stop chat
sudo docker rm chat
sudo docker rmi questao4/chat
sudo docker build -t questao4/chat .
sudo docker run -p 8080:8080 --name chat questao4/chat
