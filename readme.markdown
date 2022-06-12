# Enterprise connection BRQ

O desafio da equipe será criar uma funcionalidade para a manutenção e busca de candidatos
contactados pela equipe de atração da BRQ.
Buscas de candidatos - permitir a busca de candidatos por campos-chave (
- nome
- e-mail 
- CPF  
- skills 
- certificações
- Skills e certificações

Métodos GET 

```sh

 - nome
/api/v1/candidate/name/{name}

- e-mail
/api/v1/candidate/email/{email}

- CPF
/api/v1/candidate/cpf/{cpf}

- skills
/api/v1/candidate/skill/{skill}

- certificações
/api/v1/candidate/certification/{certification}

- skills e certificações
/api/v1/candidate/certification/{certification}/skill/{skill}
```


## Docker 

```sh

dockerhub 
docker pull pdevtest/java-app:1.0

build 
docker build -t pdevtest/java-app:1.0 .

docker run 
docker run -p 8080:8080 java-app:1.0

```
