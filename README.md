# 🧸 Catálogo de Brinquedos

API REST desenvolvida com Spring Boot responsável por gerenciar toda a lógica de negócio do sistema de catálogo de brinquedos.

Este serviço fornece endpoints para gestão de usuários, brinquedos e categorias, além de estruturar a base para futuras funcionalidades como autenticação segura, controle de acesso e expansão para e-commerce.

---

# 🚀 Visão Geral

O back-end do projeto foi construído seguindo boas práticas de desenvolvimento com Java, utilizando arquitetura em camadas (Controller → Service → Repository → Entity), garantindo organização, escalabilidade e fácil manutenção.

A API é consumida por um front-end web, sendo responsável por:

* Processamento de requisições
* Regras de negócio
* Persistência de dados
* Estruturação dos dados retornados

---

# 🛠️ Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Spring Security
* Hibernate
* Maven
* MySQL
  
---

# 📂 Arquitetura do Projeto

A aplicação segue o padrão de arquitetura em camadas:

controller → Entrada das requisições (API REST)
service    → Regras de negócio
repository → Comunicação com o banco
entity     → Modelos de dados

---

# 📂 Estrutura de Diretórios

src/main/java/br/edu/fatecgru/

├── controller
├── service
├── repository
├── entity
├── dto
└── config

---

# 📡 API REST

A API segue o padrão RESTful, com endpoints organizados por recurso.

# Exemplo: 👤 Usuários

GET    /usuarios        → Listar usuários
POST   /usuarios        → Criar usuário
GET    /usuarios/{id}   → Buscar por ID
PUT    /usuarios/{id}   → Atualizar usuário
DELETE /usuarios/{id}   → Remover usuário

---

# 👤 Tipos de Usuário

O sistema possui dois tipos de usuários:

* **ADMIN** → gerenciamento do catálogo
* **CLIENTE** → visualização dos brinquedos

---

# 🔐 Regras de Negócio

* Usuários podem ser do tipo ADMIN ou CLIENTE
* Apenas usuários ADMIN poderão gerenciar o catálogo (estrutura preparada)
* Validações básicas de dados são aplicadas antes da persistência
* Relacionamento entre brinquedos e categorias é obrigatório

# 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para praticar:

* Arquitetura MVC
* APIs REST
* Integração Front-End e Back-End
* Persistência de dados com JPA
* Organização de projetos Java
* Spring Security

---

# ⚙️ Como Executar o Projeto

1️⃣ Pré-requisitos

* Java 21 instalado
* Configurar banco de dados no application properties 
* Executar banco de dados 

---

# 📌 Funcionalidades Atuais

✔ Cadastro de usuários
✔ Login de usuários
✔ Listagem de brinquedos
✔ Organização por categorias
✔ Organização por marcas
✔ Persistência de dados
✔ Integração web com front

---

# 👨‍💻 Autor

Desenvolvido por **Arthur Portilio Suguiura da Silva**, **Heitor Cortez Norilla**, **Matheus Fernandes da Silva** e **Renan Amaral Luz Alvarado**

Projeto acadêmico desenvolvido para prática de desenvolvimento web com **Java + Spring Boot**.

---

# 📄 Licença

Este projeto é apenas para fins educacionais.
