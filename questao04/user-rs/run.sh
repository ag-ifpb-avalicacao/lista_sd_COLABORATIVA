mvn clean install
sudo docker stop user
sudo docker rm user
sudo docker rmi questao4/user
sudo docker build -t questao4/user .
sudo docker run -p 8081:8080 --name user questao4/user
