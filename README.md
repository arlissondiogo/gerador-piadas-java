# 🤣 Gerador de Piadas — Java Console App

Um projeto simples em **Java** que consome a API pública [JokeAPI](https://v2.jokeapi.dev/) para exibir piadas aleatórias de diferentes categorias diretamente no console.  
Além disso, o app traduz automaticamente as piadas para **português** usando a API do [MyMemory Translator](https://mymemory.translated.net/).

---

## 🚀 Tecnologias utilizadas

- ☕ **Java 17+**
- 🌐 **JokeAPI (v2)** — para buscar as piadas
- 🌍 **MyMemory API** — para traduzir as piadas para português
- 📦 **Gson** — para conversão entre JSON ↔️ Java Objects

---

## 🧩 Estrutura do projeto

```
src/
└── br/com/estudoAPI/
    ├── Application.java        → Classe principal (executa o programa)
    ├── config/
    │   └── ConfigApi.java      → Comunicação com as APIs externas
    ├── model/
    │   └── Piadas.java         → Modelo que representa os dados da piada
    ├── service/
    │   └── PiadaService.java  → Lógica principal de geração e tradução
    └── util/
        └── ConsoleUtil.java    → Exibição e interação com o usuário
```

---

## 💡 Como usar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/arlissondiogo/gerador-piadas-java.git
   cd gerador-piadas-java
2. Baixe o Gson (se ainda não tiver):

[gson-2.10.1.jar](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar)

3. Compile e execute o projeto:

```bash
javac -cp gson-2.10.1.jar src/br/com/estudoAPI/**/*.java -d out
java -cp out;gson-2.10.1.jar br.com.estudoAPI.Application
```

4. Siga as instruções no terminal:

- Escolha uma categoria (ex: programming, misc, pun, spooky, christmas);
- Veja a piada traduzida 😄;
- Escolha se quer outra piada!

## 🧠 Exemplo de saída

```java
======================================
       🤣  GERADOR DE PIADAS 🤣
======================================
Categorias disponíveis:

  Any         → Qualquer categoria
  Programming → Piadas de programador 💻
  Misc        → Diversas / aleatórias
  Pun         → Trocadilhos 😜
  Spooky      → Assustadoras 👻
  Christmas   → Natalinas 🎄
--------------------------------------
Digite uma categoria: programming

--------------------------------------
🃏  PIADA  🃏
--------------------------------------
😄 Por que os programadores preferem o escuro?
👉 Porque a luz atrai bugs. 🐞
--------------------------------------
Quer ver outra piada? (s/n):

```

## ⚠️ Observações

- Algumas traduções podem sair incorretas ou engraçadas devido às limitações da API gratuita.
- O código já filtra categorias inadequadas, mas como a JokeAPI é pública, ainda pode haver piadas com conteúdo ofensivo.
- É possível personalizar o tempo de exibição ou desativar a tradução automática no arquivo ConfigApi.java.
- Este projeto não compactua com piadas ofensivas, discriminatórias ou de humor negro — por isso, a categoria “Dark” foi removida.
- O objetivo é puramente educacional, voltado ao aprendizado de integração com APIs.

## 🪪 Licença

Este projeto é de uso livre para fins de estudo e aprendizado.