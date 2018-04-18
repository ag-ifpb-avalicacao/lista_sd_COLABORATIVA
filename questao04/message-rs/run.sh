mvn clean install
sudo docker stop message
sudo docker rm message
sudo docker rmi questao4/message
sudo docker build -t questao4/message .
sudo docker run -p 8083:8080 --name message questao4/message
