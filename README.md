# Challenge Backend AmeDigital

Desafio do processo seletivo (provavelmente) da AmeDigital, realizado para praticar meus conhecimentos em Java. A solução está no meu DockerHub e é detalhada posteriormente.

Repositório do desafio: https://github.com/AmeDigital/challenge-back-end-hit

Este desafio foi encontrado em: https://github.com/CollabCodeTech/backend-challenges

### Resumo 

O desafio consiste em criar uma API para gerenciar planetas do Star Wars. 
Cada planeta possui nome, clima, terreno e número de aparições em filmes. 
Esta última informação não é informada no endpoint de criação, e deve ser obtida pela API pública https://swapi.dev/ (antiga https://swapi.co/, presente no repositório do desafio).

A API construída deve ser capaz de adicionar, remover, listar todos, buscar por id e por nome.

### Solução

A solução foi construída com Spring Boot e PostgreSQL, e está em um container presente no DockerHub: andreepdias/challenge-backend-amedigital. 
Para executar a aplicação (Spring Boot), basta entrar na pasta "docker" e executar o arquivo docker-compose.yml. Nota-se que é necessário um container para o PostgreSQL, por isso a necessidade de um orquestrador de containers.

`cd docker`

`docker-compose up -d`

#### Endpoints

A porta exposta pelo container é a 8080, portanto a API pode ser acessada através de `http://localhost:8080/`.

`POST http://localhost:8080/planets/`: cria um planeta, composto pelos atributos: `name`, `terrain`, `climate`.

`DELETE http://localhost:8080/planets/id`: deleta um planeta específico.

`GET http://localhost:8080/planets/`: lista todos os planetas cadastrados.

`GET http://localhost:8080/planets/?name=`: lista todos os planetas cadastrados, filtrando por nome.

`GET http://localhost:8080/planets/id`: busca um planeta específico.
