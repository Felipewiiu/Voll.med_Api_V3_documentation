## 💻 Sobre o projeto

Voll.med é uma clínica médica fictícia que precisa de um aplicativo para gestão de consultas. O aplicativo deve possuir
funcionalidades que permitam o cadastro de médicos e de pacientes, e também o agendamento e cancelamento de consultas.

Enquanto um time de desenvolvimento será responsável pelo aplicativo mobile, o nosso será responsável pelo
desenvolvimento da API Rest desse projeto.

---

## ⚙️ Funcionalidades

- [x] CRUD de médicos;
- [x] CRUD de pacientes;
- [ ] Agendamento de consultas(em breve);
- [ ] Cancelamento de consultas(em breve);

---

## 🎨 Layout

O layout da aplicação mobile está disponível neste
link: <a href="https://www.figma.com/file/N4CgpJqsg7gjbKuDmra3EV/Voll.med">Figma</a>

---

## 📄 Documentação

A documentação das funcionalidades da aplicação pode ser acessada neste
link: <a href="https://trello.com/b/O0lGCsKb/api-voll-med">Trello</a>

---

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**
- **[MySQL](https://www.mysql.com)**
- **[Hibernate](https://hibernate.org)**
- **[Flyway](https://flywaydb.org)**
- **[Lombok](https://projectlombok.org)**
- **[Swagger](https://springdoc.org/)**

---

## 📝 Licença

Projeto desenvolvido por [Alura](https://www.alura.com.br) e utilizado nos cursos de Spring Boot.

Instrutor: [Rodrigo Ferreira](https://cursos.alura.com.br/user/rodrigo-ferreira)

---

## Como injetar um conjunto de classes em um serviço?

## SpringDoc

## Tipos de testes automatizados

1. Testes de Unidade (Unit Tests):
Testes que verificam a funcionalidade de unidades isoladas de código, como métodos ou classes individuais. Para APIs,
isso pode incluir testes de métodos que processam entradas e produzem saídas esperadas.

2. Testes de Integração (Integration Tests):
Testes que verificam a interação entre diferentes partes do sistema. Para APIs, isso envolve testar se os componentes da
API funcionam corretamente em conjunto.

## Testes automatizados

Imagine que você está construindo uma casa. Durante a construção, você precisa testar cada etapa para garantir que tudo
está funcionando corretamente. Os testes automatizados são como os engenheiros que verificam se as paredes estão bem
construídas, se a fiação elétrica está correta, se as tubulações estão funcionando, entre outros.

Nesse projeto, usamos a biblioteca JUnit, que é como um conjunto de ferramentas que os engenheiros usam para
realizar esses testes automatizados. O JUnit já está incluído no projeto do Spring Boot, assim como outras ferramentas
úteis.

Além disso, configuraramos um banco de dados exclusivo para os testes. É como ter um ambiente de testes
separado da casa principal, onde você pode fazer todas as verificações necessárias sem afetar o funcionamento da casa em
si.

*Detalhes de implementações*

1. Para se testatar uma classe é preciso avisar ao spring com uma notação ``@DataJpaTest``
2. Apontar qual aplication.properties ele deve se referenciar para os testes ``@AutoConfigureTestDatabase``
3. Criar o banco de testes que no caso é o *[application-test]*

## Testando uma classe controller

para testar o Controller no Spring Boot, que é responsável por receber as requisições dos
clientes na API e chamar as classes que executam as regras de negócio e persistência. Utilizamos a classe MockMvc do
Spring para simular requisições HTTP e testamos o cenário em que uma requisição inválida é feita para agendar uma
consulta, verificando se o código de resposta é 400. Além disso, utilizei a anotação @WithMockUser para simular um
usuário logado durante o teste.

**Detalhes**

1. Para subir o contesto completo do spring é necessário usar a anotação ``@SpringBootTest``
2.

# V o l l . m e d _ A p i _ V 3 _ 
 
 