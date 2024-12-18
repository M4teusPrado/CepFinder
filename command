# Parar todos os contêineres
sudo docker stop $(sudo docker ps -q -a)

# Remover todos os contêineres
sudo docker rm $(sudo docker ps -aq)

# Remover todas as imagens (forçando se necessário)
sudo docker rmi -f $(sudo docker images -q)


sudo docker run -d -p 8080:8080 \
-e DATABASE_URL=jdbc:postgresql://54.174.204.170:5432/cep_finder_db \
-e DATABASE_USERNAME=postgres \
-e DATABASE_PASSWORD=secret \
--name app-cepfinder mateussp18/cepfinder

sudo docker run --name postgres-cepfinder \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=secret \
-e POSTGRES_DB=cep_finder_db \
-p 5432:5432 \
postgres:latest