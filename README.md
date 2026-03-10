# 🧸 Catálogo de Brinquedos

Sistema web de **catálogo de brinquedos infantis** desenvolvido com **Spring Boot (Back-End)** e **HTML, CSS e JavaScript (Front-End)**.

O objetivo do projeto é permitir que usuários visualizem brinquedos organizados por categorias, com sistema de cadastro e autenticação de usuários.

---

# 🚀 Tecnologias Utilizadas

## Back-End

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven
* MySQL

## Front-End

* HTML5
* CSS3
* JavaScript
* Consumo de API REST

---

# 📂 Estrutura do Projeto

## Back-End

src/main/java
│
├── controller → Endpoints da API
├── service → Regras de negócio
├── repository → Acesso ao banco de dados
└── model/entity → Entidades do sistema

Principais entidades:

* **Usuario**
* **Brinquedo**
* **Categoria**

---

## Front-End

index.html → Página principal do catálogo
login.html → Tela de login
cadastro.html → Cadastro de usuários
recuperar_senha.html → Recuperação de senha

Diretórios:

css/ → Estilos da aplicação
js/ → Scripts e integração com API
img/ → Imagens de brinquedos, marcas e categorias

---

# ⚙️ Como executar o projeto

## 1️⃣ Clonar o repositório

```bash
git clone https://github.com/seu-usuario/catalogo-brinquedos.git
```

---

## 2️⃣ Rodar o Back-End

Entre na pasta:

```bash
cd Catalogo-de-Brinquedos-Back-End
```

Execute:

```bash
./mvnw spring-boot:run
```

Ou execute a classe:

```
CatalogoBrinquedosApplication.java
```

---

## 3️⃣ Rodar o Front-End

Abra o arquivo:

```
index.html
```

ou utilize a extensão **Live Server** no VSCode.

---

# 📡 API

Exemplos de endpoints:

### Usuários

```
GET /usuarios
POST /usuarios
```

### Brinquedos

```
GET /brinquedos
POST /brinquedos
PUT /brinquedos/{id}
DELETE /brinquedos/{id}
```

### Categorias

```
GET /categorias
POST /categorias
```

---

# 👤 Tipos de Usuário

O sistema possui dois tipos de usuários:

* **ADMIN** → gerenciamento do catálogo
* **CLIENTE** → visualização dos brinquedos

---

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para praticar:

* Arquitetura MVC
* APIs REST
* Integração Front-End e Back-End
* Persistência de dados com JPA
* Organização de projetos Java

---

# 📌 Funcionalidades Atuais

✔ Cadastro de usuários
✔ Login de usuários
✔ Listagem de brinquedos
✔ Organização por categorias
✔ Consumo de API no front-end
✔ Interface web do catálogo

---

# 🔮 Funcionalidades Futuras

Algumas melhorias planejadas para o projeto:

### 🔐 Segurança

* Autenticação com **Spring Security**
* Senhas criptografadas com **BCrypt**
* Controle de acesso por tipo de usuário

### 🧸 Catálogo

* Filtro de brinquedos por:

  * categoria
  * idade
  * preço
* Busca avançada

### ❤️ Usuário

* Lista de **brinquedos favoritos**
* Perfil do usuário com foto
* Histórico de visualização

### 🛒 Loja (evolução do projeto)

* Carrinho de compras
* Simulação de pedidos
* Sistema de avaliação de brinquedos

### 📊 Administração

* Dashboard de administração
* Cadastro de novos brinquedos
* Upload de imagens

---

# 📸 Interface

O sistema possui:

* Página inicial com catálogo
* Sistema de login
* Cadastro de usuários
* Visualização de categorias
* Página de recuperação de senha

---

# 👨‍💻 Autor

Desenvolvido por **Arthur Portilio Suguiura da Silva**, **Heitor Cortez Norilla**, **Matheus Fernandes da Silva** e **Renan Amaral Luz Alvarado**

Projeto acadêmico desenvolvido para prática de desenvolvimento web com **Java + Spring Boot**.

---

# 📄 Licença

Este projeto é apenas para fins educacionais.
