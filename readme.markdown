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

Exemplos Métodos GET 

- nome
```sh
http://localhost:8080/api/v1/candidate/name/{name}
```

- e-mail
```sh
http://localhost:8080/api/v1/candidate/email/{email}
```

- CPF
```sh
http://localhost:8080/api/v1/candidate/cpf/{cpf}
```

- skills
```sh
http://localhost:8080/api/v1/candidate/skill/{skill}
```

- certificações
```sh
http://localhost:8080/api/v1/candidate/certification/{certification}
```

- skills e certificações
```sh
http://localhost:8080/api/v1/candidate/certification/{certification}/skill/{skill}
```
