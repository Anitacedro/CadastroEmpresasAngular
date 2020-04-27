# CadastroEmpresasAngular


Projeto de cadastro de empresas usando Postgres e angular 6/7
Para a execução correta da aplicação é necessário que seja instalado o postgres "https://www.postgresql.org/download/" e 
nele seja criado o database "cadastro" (postgresql://localhost:5432/cadastro) pelo pgAdmin ou pelo shell.
OBS: no arquivo application.properties contém as informações do banco, caso a criação do banco seja diferente, favor alterar usuário 
e senha do arquivo.

Na aplicação foi criado um swagger para chamada dos endpoints. Para acesso (http://localhost:80080/swagger-ui.html)

Para executar o angular, é necessário entrar na pasta do projeto CadastroEmpresasAngular/Front-end/angular/ e executar 
as seguintes chamadas : ng add @ng-bootstrap/ng-bootstrap e npm i ng2-search-filter --save e então basta dar o comando "ng serve" dentro da pasta que o serviço será startado.

