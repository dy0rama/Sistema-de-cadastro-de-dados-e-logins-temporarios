# 🔐 API de Autenticação com Acesso Temporário

Projeto desenvolvido em **Java com Spring Boot** para implementar um sistema de cadastro e autenticação de usuários, utilizando **Spring JDBC e PostgreSQL** para persistência dos dados.

Após o cadastro, o usuário pode realizar o login e, quando autenticado, recebe **acesso temporário a uma API protegida durante 1 minuto**, utilizando controle de sessão com `HttpSession`.

## 🚀 Funcionalidades

    * Cadastro de usuários
    * Persistência de dados no PostgreSQL
    * Autenticação por e-mail e senha
    * Login através de API REST
    * Criação de sessão autenticada
    * Controle de acesso temporário de 1 minuto
    * Proteção de endpoints através da sessão
    * Retorno de mensagens de acesso autorizado ou negado
    * Encerramento do acesso após expiração da sessão

## 🔄 Fluxo da aplicação

```text
Cadastro
   ↓
POST /usuarios
   ↓
PostgreSQL
   ↓
Login
   ↓
POST /auth/login
   ↓
Validação das credenciais
   ↓
Criação da sessão
   ↓
Acesso temporário por 1 minuto
   ↓
GET /api-protegida
   ↓
"Acesso garantido."
```

Após o período de 1 minuto, a sessão expira e o acesso à API protegida é bloqueado.

## 🏗️ Arquitetura

O projeto utiliza uma arquitetura baseada em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
JdbcTemplate
    ↓
PostgreSQL
```

### Controller

Responsável por receber as requisições HTTP e retornar as respostas da API.

### Service

Responsável pelas regras de negócio, incluindo cadastro e autenticação dos usuários.

### Repository

Responsável pela comunicação com o banco de dados utilizando `JdbcTemplate`.

## 🛠️ Tecnologias

    * Java
    * Spring Boot
    * Spring MVC
    * Spring JDBC
    * JdbcTemplate
    * PostgreSQL
    * Maven
    * REST API
    * HTTP/JSON
    * HttpSession

## 📌 Principais endpoints

### Cadastro

```http
POST /usuarios
```

Exemplo:

```json
{
    "nome": "Rodrigo",
    "email": "rodrigo@email.com",
    "senha": "123456"
}
```

### Login

```http
POST /auth/login
```

Parâmetros:

```text
email=rodrigo@email.com
senha=123456
```

Após a autenticação, uma sessão é criada com duração de **60 segundos**.

### API protegida

```http
GET /api-protegida
```

Com uma sessão válida:

```text
Acesso garantido.
```

Após a expiração da sessão:

```text
Acesso negado. Faça login novamente.
```

## 🎯 Objetivo

O objetivo do projeto é aplicar, na prática, conceitos de **desenvolvimento backend com Spring Boot**, construção de **APIs REST**, persistência de dados utilizando **JDBC**, autenticação de usuários e controle de acesso através de sessões temporárias.

O projeto também serve como estudo de **arquitetura em camadas, injeção de dependências, HTTP, SQL e gerenciamento de sessões no Spring MVC**.

## 📚 Conceitos praticados

    * APIs REST
    * Spring Boot
    * Spring MVC
    * Injeção de dependências
    * `@RestController`
    * `@Service`
    * `@Repository`
    * `@PostMapping`
    * `@GetMapping`
    * `@RequestBody`
    * `@RequestParam`
    * `ResponseEntity`
    * `JdbcTemplate`
    * SQL
    * PostgreSQL
    * `HttpSession`
    * Controle de sessão
    * Autenticação
    * HTTP Status Codes
    * Arquitetura em camadas
