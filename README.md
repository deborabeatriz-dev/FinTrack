# **FinTrack-Analise de Gastos**
Fintrack é um sistema de controle de gastos financeiros

- [Configurando Ambiente](#configurando-ambiente)
- [Iniciando o ambiente de testes](#iniciando-o-ambiente-de-testes)
- [Instalação do PostgreSQL](#instalação-do-postgresql)


## Configurando Ambiente

- Para a configuração básica do ambiente será necessária a instalação do Apache Maven e do Java.
    - Após a instalação de ambos é recomendada realizar o download das Extensions Packs, tanto do Java quanto do Spring Boot (VScode).

## Iniciando o ambiente de testes

- Para iniciar o ambiente para testes (localhost) você precisará usar o comando ```mvn spring-boot:run```, se a instalação do Java e do Maven estiverem corretas a aplicação irá iniciar no caminho ```localhost:8080```.

## Instalação do PostgreSQL

- Para uma organização de testes mais livres na parte do banco de dados, instanciaremos um banco de dados no computador de cada desenvolvedor e usaremos o acesso à AWS apenas para a produção ou testes dependentes do ambiente de produção.

**Sessão em desenvolvimento**
