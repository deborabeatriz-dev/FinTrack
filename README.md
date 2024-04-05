# **FinTrack: Análise de Gastos**
Fintrack é um sistema de controle de gastos financeiros

- [Configurando Ambiente](#configurando-ambiente)
- [Iniciando o ambiente de testes](#iniciando-o-ambiente-de-testes)
- [Instalação do PostgreSQL](#instalação-do-postgresql)
- [Conectando a aplicação ao banco](#conectando-a-aplicação-ao-banco)
- [Branches e GitFlow](#branches-e-gitflow)


## Configurando Ambiente

- Para a configuração básica do ambiente será necessária a instalação do Apache Maven e do Java.
    - Após a instalação de ambos é recomendada realizar o download das Extensions Packs, tanto do Java quanto do Spring Boot (VScode).

## Iniciando o ambiente de testes

- Para iniciar o ambiente para testes (localhost) você precisará usar o comando ```mvn spring-boot:run```, se a instalação do Java e do Maven estiverem corretas a aplicação irá iniciar no caminho ```localhost:8080```.

## Instalação do PostgreSQL

- Para uma organização de testes mais livres na parte do banco de dados, instanciaremos um banco de dados no computador de cada desenvolvedor e usaremos o acesso à AWS apenas para a produção ou testes dependentes do ambiente de produção.
    - Para instalar o servidor do PostgreSQL basta ir no [site](https://www.postgresql.org/download/) e seguir os passos de instalação para o sistema operacional de sua preferência.

**Atenção**

Ao instalar o postgreSQL ele pedirá a definição de uma senha para o usuário principal, recomendo a utilização da senha ```root```, que é uma das senhas padrões para todos os servidores locais de banco de dados.

## Conectando a aplicação ao banco

- Para conectar a aplicação ao banco de dados, é necessário alterar o arquivo ```application.properties``` localizado no caminho ```src\main\resources``` a partir da pasta raíz do projeto.
Como padrão o conteúdo do arquivo será parecido com isso:
```
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false
spring.jpa.hibernate.ddl-auto=update
```
- As únicas alterações necessárias serão nos campos de ```spring.datasource.url```, ```spring.datasource.username``` e ```spring.datasource.password``` que serão alteradas baseadas na instalação feita do PostgreSQL.
Exemplo: 
```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres?useSSL=false
spring.datasource.username=postgres
spring.datasource.password=root
```

- Se a conexão com o banco for realizada com sucesso, assim que o comando ```mvn spring-boot:run``` for utilizado, serão criadas as tabelas anotadas nos Models do projeto.

## Branches e GitFlow

- Em projetos bem estruturados, é aplicado um sistema rigoroso de versionamento, baseado em [GitFlow](https://www.alura.com.br/artigos/git-flow-o-que-e-como-quando-utilizar).

**GitFlow**
Ao clicar no link acima você será redirecionado para uma leitura básica sobre GitFlow. 

![Imagem GitFlow](https://www.alura.com.br/artigos/assets/git-flow-o-que-e-como-quando-utilizar/imagem3.png).

O GitFlow consiste basicamente em um sistema de organização de branches para organizar o deployment do código em projetos onde vários devs trabalham.

- **Branches de desenvolvedores\demandas:** São o nível mais baixo de branches (Feature na imagem acima), são nelas onde os desenvolvedores desenvolvem as suas demandas antes de subir para a branch de Develop\Homologação. Essas branches podem ser criadas especificamente para as demandas (prática mais comum em projetos estruturados) ou em branches separadas por desenvolvedor. Esse tipo de branch nunca subirá para a Master e sim para a Develop\Homologação para realização de testes da aplicação em geral.

- **Branch de Develop\Homologação:** É o meio do caminho para a produção. Essa é a branch onde serão realizados testes na aplicação para observar se as coisas estão funcionando devidamente. Essa branch pode ser mesclada com a branch de **Release** para a centralização de novas funcionalidades que serão liberadas para produção, ou pode ser mesclada com a **Master** em projetos mais diretos.

- **Master**: É a versão que aparece para a produção, onde os códigos mesclados já foram testados. Raramente desenvolvedores vão atuar na Master, visto que toda alteração realizada nela reflete na aplicação que será consumida pelo cliente.

## Pull, Push e Pull Requests

**Sessão em desenvolvimento**