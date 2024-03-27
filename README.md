## Introdução

Projeto MiniShop utilizando Spring Boot versão 3.0.7 e Java 17 com Clean Architecture com as bibliotecas Validation, Lombok, Data JPA, Flyway, MSSQL ou Oracle.

## Pré-requisitos

1. Docker;
2. Java 17;
3. SQL Server Management Studio (MSSQL) ou SQL Developer (Oracle), DBeaver e outros navegadores de banco de dados são suportados também;
4. Intellij como editor de texto.

## Fluxo de trabalho

Nesse projeto teremos o seguinte fluxo de trabalho:

1. Você não poderá realizar alterações na branch `main` somente através de [Pull Requests](https://learn.microsoft.com/azure/devops/repos/git/about-pull-requests?view=azure-devops-2020);

2. Você deverá criar branchs respeitando as nomenclaturas do GitFlow:

    - `feat/` ou `feature/`: Para implementações novas;
    - `bugfix/` ou `hotfix/`: Para correções de implementações já presentes na branch `main`;

3. Assim que sua implementação for concluída você deverá realizar o push e solicitar a entrega através de um Pull Request;

    - O [pull_request_template.md](.azuredevops/pull_request_template.md) é o seu template de Pull Requests, ele cria uma descrição orientando você e seus colegas de time como devem trabalhar;
    - O Pull Request é uma documentação do trabalho realizado e revisado pelo time portanto é muito importante que todos os membros do time o **REVISEM**.

4. A entrega final deve estar contida na branch `main`.

## Docker

As configurações para utilizar MSSQL ou Oracle estão no arquivo [docker-compose.yml](docker-compose.yml) que está na raíz do projeto, por padrão o BD escolhido é MSSQL para utilizar Oracle siga as instruções no arquivo.

Passos para executar o docker:

1. No nivel do arquivo `docker-compose.yml`, digitar:

    - No Windows:

    <br/>

    ```bash
    wsl docker-compose up -d
    ```

    - Linux/Mac OS:

    <br/>

    ```bash
    docker-compose up -d
    ```

2. Após isso precisamos criar nosso banco de dados, podemos fazer isso direto pela linha de comando do docker:

    - No Windows com SQL Server:

    <br />

    ```bash
    wsl docker compose exec -it <nome_service_compose> /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P 'Cpc33UBI' -Q 'CREATE DATABASE minishop'
    ```

    - Linux/Mac OS com SQL Server:

    <br />

    ```bash
    docker compose exec -it <nome_service_compose> /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P 'Cpc33UBI' -Q 'CREATE DATABASE minishop'
    ```

> **Considerações:** Algumas considerações sobre docker com banco de dados:
>
> - Informações de acesso ao banco de dados no arquivo [application.properties](./src/main/resources/application.properties)
> - Uma vez executado o comando `docker-compose up -d` nas próximas vezes que precisar iniciar ou parar os contâiners de banco utilize os comandos `docker-compose start` ou `docker-compose stop`;
> - A VPN deve estar desconectada e os serviços de SQL instalados na máquina desativados para que a conexão aconteça com sucesso;
> - Para verificar status Docker utilize comando `docker ps`;
> - O comando `docker exec` é capaz de executar programas dentro do nosso contâiner, mais informações [aqui](https://docs.docker.com/engine/reference/commandline/exec/).

# Configuração das Chaves de Acesso da AWS 

Para utilizar os serviços da Amazon Web Services (AWS) em nossa aplicação, é necessário configurar as chaves de acesso adequadas e integrar com o Amazon S3 para leitura e escrita de objetos. Siga os passos abaixo para configurar suas chaves de acesso e integrar com o Amazon S3:

1. **Acessando o Console da AWS:**
   Acesse o [Console de Gerenciamento da AWS](https://aws.amazon.com/console/) e faça login na sua conta da AWS.

2. **Acessando o Painel de Controle IAM:**
   No console da AWS, vá para o Painel de Controle do IAM (Identidade e Acesso do AWS). Você pode encontrá-lo na seção "Security, Identity, & Compliance".

3. **Criando um Usuário IAM:**
   - Selecione "Usuários" no painel de navegação esquerdo e clique em "Adicionar usuário".
   - Escolha um nome para o usuário, por exemplo, "my-application-user".
   - Selecione o tipo de acesso. Recomendamos selecionar "Acesso programático" para usar as chaves de acesso para a API da AWS.
   - Clique em "Próximo: Permissões" e adicione as permissões necessárias para o usuário. Por exemplo, você pode conceder permissões de leitura/gravação no Amazon S3.
   - Clique em "Próximo: Tags" e adicione tags se desejar. Caso contrário, clique em "Próximo: Revisar" e, em seguida, em "Criar usuário".

4. **Obtendo as Chaves de Acesso:**
   Após criar o usuário, você será redirecionado para a página de resumo. Aqui, você verá a seção "Chave de acesso". Clique em "Mostrar" ao lado de "Chave de acesso da AWS" e "Chave de acesso secreta da AWS". Anote essas chaves, pois elas serão usadas para configurar a autenticação da AWS na aplicação.

5. **Configurando as Chaves de Acesso no AWS CLI:**
   Se preferir configurar as chaves de acesso diretamente no AWS CLI, você pode utilizar o comando `aws configure` e inserir as informações solicitadas. Certifique-se de ter o AWS CLI instalado e configurado em sua máquina local. Execute o seguinte comando no terminal:


Este comando irá solicitar as seguintes informações:
- Access Key ID: Insira sua chave de acesso da AWS.
- Secret Access Key: Insira sua chave secreta da AWS.
- Default region name: Insira a região padrão do seu bucket do Amazon S3.
- Default output format: Escolha o formato de saída padrão para as respostas do AWS CLI (opcional).

Siga as instruções na linha de comando para inserir as informações solicitadas.

Se preferir configurar manualmente o arquivo de configuração do AWS CLI, você pode encontrar o arquivo `credentials` no diretório `~/.aws/` (Linux/macOS) ou `%USERPROFILE%/.aws/` (Windows). Edite este arquivo e adicione as chaves de acesso conforme mostrado abaixo:


Substitua `sua-chave-de-acesso` e `sua-chave-secreta` pelas chaves de acesso e secreta que você obteve anteriormente.

## Execução

1. Atualizar as dependências do Maven.

    - Pelo console:

    <br/>

    ```bash
    mvn clean install
    ```

    - Pelo Intellij: Clicar com o botão direito em cima do arquivo pom.xml -> Maven -> Reload Project

> **Considerações:** Caso IDE não reconheça projeto Spring alterar configurações em File -> Build, Execution,
> Deployment -> Maven na opção Maven home path alterar para Maven 3

2. A aplicação pode ser acessada, após a execução, em <http://localhost:8080>

> **Configurações:**
>
> No arquivo [application.properties](src/resources/application.properties) temos a seguinte instrução na linha 5:
>
> ```properties
> spring.profiles.active=dev
> ```
>
> Define que o profile ativo nessa instância da aplicação é o "dev" (de development). Ou seja, informamos que estamos em um ambiente de desenvolvimento e conseguimos definir algumas variáveis desse ambiente através do arquivo [application-dev.properties](src/resources/application-dev.properties).
>
> **Documentação:** Leia mais sobre [aqui](https://www.baeldung.com/spring-profiles).

## Migrations

Para versionar nosso banco de dados estamos utilizando migrations através do [Flyway](https://flywaydb.org/), mais informações nesse [tutorial](https://www.baeldung.com/database-migrations-with-flyway).

> **Importante:** O projeto ja está preparado para receber as migrations basta configurá-las na pasta (src/main/resources/db/migration)

## Testes

Para os Testes Unitários utilizamos a annotation @RunWith(MockitoExtension.class) indicando que os testes são realizados sem integrações externas.
Para os Testes de Integração utilizamos as annotations @SpringBootTest e @ActiveProfiles indicando que  os testes não possuem mocking e apontam para o profile 'test'.

> **Documentação:** Leia mais sobre [aqui](https://www.baeldung.com/spring-boot-testing).

## Documentação Api

Para acessar o swagger: <http://localhost:8080/swagger-ui/index.html>

> **Considerações:** Para configuração do Swagger foi utilizada biblioteca SpringDoc com utilização Open API.
> 
> **Documentação:** Leia mais [aqui](https://springdoc.org/).

## Arquitetura da Api

O modelo da API foi desenvolvido baseado na Clean Architecture (Arquitetura Limpa).

> **Documentação:** Leia mais sobre Clean Architecture[aqui](https://medium.com/luizalabs/descomplicando-a-clean-architecture-cf4dfc4a1ac6).

## Logs

Para criar um arquivo de log customizado, basta 'descomentar' a linha 3 do [application-dev.properties](./src/main/resources/application-dev.properties). Por padrão será criado um arquivo chamado arquivolog.log na raíz do projeto:

```properties
#logging.file.name=arquivolog.log
```

## Health Check Endpoint

Para verificação de métricas e diferentes parâmetros é possível utilizar o Actuator do Spring.
Você pode verificar conexão com o banco de dados através do endpoint: <http://localhost:8080/actuator/health>

> **Documentação:** Leia mais sobre [aqui](https://docs.spring.io/spring-boot/docs/current/actuator-api/htmlsingle/).