# 📚 Biblioteka REST API

**Biblioteka REST API** é uma aplicação desenvolvida em Java utilizando Spring Boot. Ela oferece uma solução eficiente para gerenciar bibliotecas, permitindo o cadastro de livros, usuários e empréstimos, além de fornecer informações sobre a disponibilidade de livros.

## 🚀 Funcionalidades

- **Gerenciamento de Usuários**:
    - Cadastro, atualização e exclusão de usuários.

- **Gerenciamento de Livros**:
    - Cadastro, atualização e exclusão de livros.
    - Verificação da disponibilidade de livros.

- **Empréstimos**:
    - Registro de empréstimos de livros.
    - Atualização da data de devolução.
    - Exclusão de registros de empréstimos.

- **Consulta e Relatórios**:
    - Listagem de todos os empréstimos registrados.
    - Consulta detalhada sobre empréstimos específicos.

## 🛠️ Tecnologias Utilizadas

- **Java 23^**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL** para armazenamento de dados
- **Maven** para gerenciamento de dependências

## 📂 Estrutura do Projeto

O projeto segue a arquitetura padrão do Spring Boot:

```plaintext
src/
├── main/
│   ├── java/com/devguilara/lib_gere/
│   │   ├── controllers/   # Endpoints da API
│   │   ├── models/        # Modelos de dados (entidades)
│   │   ├── repository/    # Interfaces para acesso ao banco de dados
│   │   └── dto/           # Objetos de transferência de dados
│   └── resources/
│       ├── application.properties  # Configurações da aplicação
│       └── data.sql                 # Scripts de inicialização
```

## 🖥️ Endpoints da API

### Livros
- **POST** `/books` - Adiciona um novo livro.
- **GET** `/books` - Lista todos os livros.
- **GET** `/books/{id}` - Detalhes de um livro específico.
- **PUT** `/books/{id}` - Atualiza informações de um livro.
- **DELETE** `/books/{id}` - Exclui um livro.

### Usuários
- **POST** `/users` - Adiciona um novo usuário.
- **GET** `/users` - Lista todos os usuários.
- **GET** `/users/{id}` - Detalhes de um usuário específico.
- **PUT** `/users/{id}` - Atualiza informações de um usuário.
- **DELETE** `/users/{id}` - Exclui um usuário.

### Empréstimos
- **POST** `/loans` - Registra um novo empréstimo.
- **GET** `/loans` - Lista todos os empréstimos.
- **GET** `/loans/{id}` - Detalhes de um empréstimo específico.
- **GET** `/loans/availability/{bookId}` - Verifica a disponibilidade de um livro.
- **PUT** `/loans/{id}` - Atualiza a data de devolução de um empréstimo.
- **DELETE** `/loans/{id}` - Exclui um empréstimo.

## ⚙️ Configuração e Execução

### Pré-requisitos
- **Java 23^**
- **Maven**
- **PostgreSQL**

### Passos para Rodar o Projeto
1. Clone este repositório:
   ```bash
   git clone https://github.com/devguilara/biblioteka-restAPI.git
   cd biblioteka-restAPI
   ```

2. Configure o banco de dados no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/sua_base
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

3. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a API em `http://localhost:8080`.
---