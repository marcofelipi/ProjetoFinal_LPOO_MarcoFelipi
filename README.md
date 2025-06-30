# Projeto Final - Gestão de Clínica Odontológica

## Objetivo do Projeto

O objetivo deste projeto foi criar uma aplicação em Java para gerenciar as operações de uma clínica odontológica. O sistema permite cadastrar pacientes, dentistas, agendar consultas e registrar os prontuários de cada atendimento.

---

## Estrutura e Decisões de Arquitetura

### 1. MODEL
- Define as classes `Paciente`, `Dentista`, `Agendamento` e `Prontuario`.
- Utiliza anotações do JPA/Hibernate para mapear cada classe em tabelas do banco de dados.

### 2. DAO
- Responsável pela comunicação com o banco de dados.
- Interface `InterfaceBD` define as operações básicas (salvar, remover, etc.).
- A implementação `PersistenciaJPA` fornece a integração real com JPA.
- Isso garante separação de responsabilidades e flexibilidade para futuras mudanças.

### 3. VIEW
- Contém todas as telas feitas em Java Swing.
- A própria View assume o papel de Controller: eventos dos botões coordenam entrada de dados, persistência e respostas ao usuário.

---

## Modelagem (Relacionamentos Entre Entidades)

- Um **Paciente** pode ter vários **Agendamentos**.
- Um **Dentista** também pode ter vários **Agendamentos**.
- Cada **Agendamento** pode gerar um único **Prontuário** associado.

---

## Diagrama de Classes UML

![image](https://github.com/user-attachments/assets/fa447005-d078-46d4-afa6-8746918e4b4f)

---

## Demonstração (Fluxo de Uso)

1. **Cadastros Base:** Primeiro, cadastramos um Paciente e um Dentista.
2. **Agendamento:** Em seguida, criamos um Agendamento, selecionando o paciente e o dentista nas listas.
3. **Prontuário:** Após a consulta, acessamos o agendamento na lista e criamos o Prontuário correspondente.
4. **CRUD:** Demonstração da edição e exclusão para mostrar o ciclo completo.

---

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/SeuUsuario/ProjetoFinal_LPOO_MarcoFelipi.git
   ```

2. Abra o projeto no NetBeans (ou outro IDE que suporte Maven).

3. Configure o banco de dados PostgreSQL com o nome:
   ```
   ProjetoFinal_MarcoFelipi
   ```

4. Verifique se o arquivo `persistence.xml` possui as credenciais corretas.

5. Execute o projeto (Shift+F6 no NetBeans). A interface gráfica será iniciada.

---

## Requisitos

- Java
- PostgreSQL
- Maven

---

## Possíveis melhorias no futuro

- Adicionar RAIO-X do tratamento (na tabela Prontuarios, pode ter um campo para adicionar uma foto, que deve subir em algum serviço online (Google Bucket ou até Google Drive, para consumir e visualizar a foto na aplicação)
    - ![image](https://github.com/user-attachments/assets/e122d41d-2ba1-4b11-b1e2-a2391204cfb4)

- Sistema de ANAMNESE (questionário com o objetivo de entender a neseccidade do paciente e limitações no tratamento. Entraria na tabela paciente, talvez com boolean para cada um dos campos de pergunta (sim ou não)
    - ![image](https://github.com/user-attachments/assets/b1b2072d-3d06-4c6b-abff-09f2941d2a74)
      
- Valor de cada atendimento, sendo possível acompanhar o faturamento da clínica.

## Autoria

Este projeto foi desenvolvido por Marco Felipi para a disciplina de Linguagem de Programação Orientada a Objetos – IFSul, com orientação da Profª Vanessa Lago Machado.
