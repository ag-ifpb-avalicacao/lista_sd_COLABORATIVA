#mvn clean install
sudo docker stop client
sudo docker rm client
sudo docker rmi questao4/client
sudo docker build -t questao4/client .
sudo docker run -p 8085:8080 -d --name client questao4/client
