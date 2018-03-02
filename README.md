# POC_API_SPRING_BOOT

Criar um banco de dados no MYSQL com o nome de poc

Editar o arquivo application.properties e alterar o usuario e senha do Mysql

Para rodar a aplicação executar a classe PocPessoaApiApplication



Os endpoints para para realizar o CRUD da API são:


Listar todos registros:
  http://localhost:8080/api (GET)
  
Buscar um registro pelo ID: 
  http://localhost:8080/api/{ID} (GET}
  
Excluir um registro pelo ID: 
  http://localhost:8080/api/{ID} (DELETE}
  
Incluir um registro: 
Método POST e usar o json abaixo:

{
    "nome": "NOME",
    "sobrenome": "SOBRENOME"
}

Alterar um registro: 
Método PUT e usar o json abaixo:

{
    "id": nr_id,
    "nome": "NOME",
    "sobrenome": "SOBRENOME"
}
