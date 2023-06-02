# Getting Started

A aplicação foi desenvolvida em Spring Boot na versão 3.1.0 e com Java 17.

Para subir a aplicação  é necessário

- mysql server
- mariadb:lastest

Em caso de dúvidas sobre o banco de dados, pode-se baixar o mysqlserver e a ultima imagem do banco mariadb em https://hub.docker.com/
após fazer pull da imagem os comandos para subir a imagem são:

$ docker run --detach --name some-mariadb --env MARIADB_USER={usuario} --env MARIADB_PASSWORD={senha} --env MARIADB_ROOT_PASSWORD={senha}  mariadb:latest

- pra inicializar o mysqlserver:
$ services start mysql (brew services start mysql - no macos) 

$ mysql -h localhost -P 3306 -u root -p

- após isso é necessário conectar ao banco mariadb e criar uma database com o nome desejado (é necessário alterar o nome no application.yml da aplicação)

- e por fim subir a backend que criará as tabelas necessárias

