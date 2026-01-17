# Gerenciador de Cursos - Fase 2

Este projeto é um Sistema de Gerenciamento de Cursos desenvolvido como parte da Fase 2, focada no desenvolvimento da Interface de Usuário (Front-end) e sua integração completa com o Back-end.

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework Back-end:** Spring Boot 3.2.5
- **Persistência de Dados:** Spring Data JPA
- **Banco de Dados:** H2 (Em memória)
- **Template Engine:** Thymeleaf
- **CSS Framework:** Tailwind CSS (via CDN)
- **Segurança:** Spring Security
- **Outras Bibliotecas:** Lombok, Jakarta Validation

## 📋 Funcionalidades Implementadas

- **CRUD Completo de Cursos:** Criação, Listagem, Edição e Exclusão.
- **Filtros Dinâmicos:** Busca de cursos por nome e categoria.
- **Toggle de Status:** Alteração rápida do status (Ativo/Inativo) via AJAX (Fetch API).
- **Segurança:** Tela de login customizada para proteger rotas de criação e edição.
- **Feedback Visual:** Mensagens de sucesso/erro e validação de campos obrigatórios.
- **Layout Responsivo:** Interface moderna desenvolvida com Tailwind CSS.
- **Auditoria Automática:** Uso de `@CreationTimestamp` e `@UpdateTimestamp` para rastreamento de registros.

## 🛠️ Como Rodar a Aplicação

### Pré-requisitos
- JDK 21 ou superior
- Maven 3.8+

### Passos para Execução
1. Clone o repositório.
2. Navegue até a pasta raiz do projeto.
3. Execute o comando Maven para iniciar a aplicação:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse a aplicação no seu navegador:
   ```
   http://localhost:8080
   ```

## 🔐 Credenciais de Acesso Standard

Para acessar as áreas restritas do sistema (Criar/Editar cursos), utilize as seguintes credenciais:

- **Usuário:** `admin`
- **Senha:** `admin`

## 📂 Estrutura do Projeto

- `src/main/java`: Código-fonte Java (Controllers, Models, Repositories, Services, Config).
- `src/main/resources/templates`: Templates HTML do Thymeleaf.
- `src/main/resources/templates/fragments`: Componentes reutilizáveis (Navbar, Footer).
- `src/main/resources/application.properties`: Configurações da aplicação.

---
Desenvolvido por **Jules AI**.
