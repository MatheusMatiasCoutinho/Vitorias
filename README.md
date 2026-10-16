<div align="center">

<img src="docs/banner.png" alt="Vitórias — Proteção, Liberdade, Dignidade" width="100%" />

<br/>

[![Android CI](https://github.com/MatheusMatiasCoutinho/Vitorias/actions/workflows/android.yml/badge.svg)](https://github.com/MatheusMatiasCoutinho/Vitorias/actions/workflows/android.yml)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android_7.0+-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Material 3](https://img.shields.io/badge/Material_3-40295F?style=for-the-badge&logo=materialdesign&logoColor=white)
![Figma](https://img.shields.io/badge/Figma-6E4A66?style=for-the-badge&logo=figma&logoColor=white)
![Status](https://img.shields.io/badge/status-em_desenvolvimento-B98A9C?style=for-the-badge)
![Licença](https://img.shields.io/badge/licen%C3%A7a-MIT-6E4A66?style=for-the-badge)

**[Sobre](#-sobre)** ·
**[Telas](#-telas)** ·
**[Arquitetura](#%EF%B8%8F-arquitetura)** ·
**[Segurança](#-privacidade-por-design)** ·
**[Roadmap](#%EF%B8%8F-roadmap)** ·
**[Executar](#-como-executar)** ·
**[Contribuir](#-como-contribuir)**

</div>

<br/>

> [!CAUTION]
> O Vitórias é informativo e **não substitui atendimento oficial**.
> Em risco imediato, ligue **190**. Para orientação e denúncia, **Ligue 180** — gratuito, 24h, em todo o Brasil.

<br/>

## 💜 Sobre

O **Vitórias** é um aplicativo Android de conscientização, orientação e apoio a mulheres em situação de vulnerabilidade, desenvolvido como projeto acadêmico do curso de **Engenharia de Software da UNICEPLAC**.

O app reúne, em linguagem acessível, os tipos de violência previstos na Lei Maria da Penha, a legislação vigente e a rede de atendimento público gratuito — Defensoria Pública, Casa da Mulher Brasileira, CRM, CREAS, CAPS e DEAM — com atalhos diretos para os canais de emergência.

Muitas usuárias podem estar sob vigilância de quem as agride. Por isso o projeto parte de uma premissa: **o app nunca pode virar prova contra quem o usa**. Sem cadastro, sem relatos na nuvem e com saída em um toque.

<br/>

## ✨ Funcionalidades

| | Módulo | O que faz |
|:---:|---|---|
| 📖 | **Informação e Direitos** | Explica os 5 tipos de violência do Art. 7º da Lei nº 11.340/2006 e resume a Lei Maria da Penha e a Lei do Feminicídio (Lei nº 13.104/2015) |
| 🎬 | **Eventos** | Carrossel automático de palestras e campanhas; cada vídeo tem descrição e link próprios |
| 🚨 | **Emergência** | Ligue 180, 190 e Disque 100 — abre o discador com o número pronto |
| 📍 | **Apoio** | Rede de atendimento mais próxima, por geolocalização, com rota até o local |
| 📝 | **Denúncia** | Ajuda a organizar o relato, em primeira ou terceira pessoa — salvo **só no aparelho** |
| 🛠️ | **Administração** | Gestão de vídeos e leis sem precisar publicar nova versão na loja |

<br/>

## 📱 Telas

<sub>Protótipo de alta fidelidade desenhado no Figma. As telas já implementadas estão marcadas no [roadmap](#%EF%B8%8F-roadmap).</sub>

<table align="center">
  <tr>
    <td align="center"><img src="docs/screens/abertura.png" width="180" alt="Abertura"/><br/><sub><b>Abertura</b></sub></td>
    <td align="center"><img src="docs/screens/home.png" width="180" alt="Home"/><br/><sub><b>Home</b></sub></td>
    <td align="center"><img src="docs/screens/emergencia.png" width="180" alt="Emergência"/><br/><sub><b>Emergência</b></sub></td>
    <td align="center"><img src="docs/screens/denuncia.png" width="180" alt="Denúncia"/><br/><sub><b>Denúncia</b></sub></td>
  </tr>
  <tr>
    <td align="center"><img src="docs/screens/informacoes-tipos.png" width="180" alt="Tipos de violência"/><br/><sub><b>Tipos de violência</b></sub></td>
    <td align="center"><img src="docs/screens/informacoes-leis.png" width="180" alt="Direitos e leis"/><br/><sub><b>Direitos e leis</b></sub></td>
    <td align="center"><img src="docs/screens/ajustes.png" width="180" alt="Ajustes"/><br/><sub><b>Ajustes</b></sub></td>
    <td align="center"><img src="docs/screens/login-admin.png" width="180" alt="Acesso restrito"/><br/><sub><b>Acesso restrito</b></sub></td>
  </tr>
</table>

<details>
<summary><b>🛠️ Ver telas da área administrativa</b></summary>
<br/>
<p align="center">
  <img src="docs/screens/admin-leis.png" width="180" alt="Administração de leis"/>
  &nbsp;&nbsp;
  <img src="docs/screens/editar-lei.png" width="180" alt="Editar lei"/>
</p>
</details>

<br/>

## 🧭 Fluxo de navegação

```mermaid
flowchart LR
    A([Abertura]) --> H[Home]
    H --> I[Informação e Direitos]
    H <--> D[Denúncia]
    H <--> P[Apoio]
    H <--> E[Emergência]
    H --> J[Ajustes]
    J --> L[Acesso restrito]
    L --> ADM[Administração]
    ADM --> EL[Editar lei]
    ADM --> EV[Editar vídeo]

    classDef pronto fill:#40295F,stroke:#40295F,color:#fff
    classDef andamento fill:#B98A9C,stroke:#B98A9C,color:#fff
    classDef planejado fill:#F7F1EC,stroke:#B98A9C,color:#6E4A66

    class A,H pronto
    class E andamento
    class I,D,P,J,L,ADM,EL,EV planejado
```

<sub>🟪 Implementada &nbsp;·&nbsp; 🟫 Em desenvolvimento &nbsp;·&nbsp; ⬜ Planejada &nbsp;·&nbsp; Denúncia, Apoio e Emergência ficam na barra inferior, acessíveis de qualquer tela.</sub>

<br/>

## 🏗️ Arquitetura

As telas não sabem de onde os dados vêm: elas pedem ao **Repository**. Hoje ele lê uma lista local; na próxima etapa passa a consultar a API. A fonte de dados muda **sem tocar na interface**.

```mermaid
flowchart TB
    subgraph APP["📱 App Android"]
        UI["Activities + XML<br/><i>ViewBinding</i>"]
        REPO["Repository"]
        UI --> REPO
    end

    REPO --> LOCAL[("Lista local<br/><i>atual</i>")]
    REPO -. próxima etapa .-> API["API REST"]
    API --> DB[("Banco SQL")]
    ADMIN["🛠️ Painel do admin"] -. cadastra conteúdo .-> API
```

> [!IMPORTANT]
> O app **nunca** se conecta direto ao banco. Todo acesso passa pela API, que autentica o admin e guarda as credenciais do banco fora do APK — qualquer coisa embutida no app pode ser extraída.

<details>
<summary><b>📦 Modelo de dados — Vídeo</b></summary>
<br/>

```mermaid
classDiagram
    class Video {
        +String titulo
        +String descricao
        +String link
        +String campus
        +Boolean exibirNaHome
        +youtubeId() String
        +miniaturaUrl() String
    }
```

A miniatura não é armazenada: é gerada a partir do ID do vídeo no YouTube. O admin cadastra só o link, e só vídeos com `exibirNaHome = true` entram no carrossel.

</details>

<details>
<summary><b>🗂️ Estrutura de pastas</b></summary>
<br/>

```
app/src/main/
├── java/br/edu/uniceplac/vitorias/
│   ├── AberturaActivity.kt      # Tela inicial
│   ├── MainActivity.kt          # Home + carrossel automático
│   ├── LoginActivity.kt         # Acesso restrito (admin)
│   ├── Video.kt                 # Modelo de dados
│   ├── VideoRepository.kt       # Fonte dos vídeos
│   └── VideoAdapter.kt          # Cards do carrossel
└── res/
    ├── layout/                  # Telas e componentes reutilizáveis
    ├── values/                  # Cores e textos (strings.xml)
    └── drawable/                # Ícones vetoriais e logo
```

</details>

<br/>

## 🔒 Privacidade por design

Cada decisão técnica abaixo existe para proteger quem usa o app.

| Decisão | Por quê |
|---|---|
| **Sem cadastro para a usuária** | Nenhum dado pessoal liga a pessoa ao aplicativo |
| **`allowBackup="false"`** | Os relatos não são copiados para a nuvem do Google |
| **Telas internas com `exported="false"`** | Nenhum outro app abre uma tela interna sem passar pela abertura |
| **Saída rápida (✕) em todas as telas** | Fecha o app inteiro com um toque |
| **`ACTION_DIAL` em vez de ligação direta** | Não exige permissão sensível; a usuária confirma antes de ligar |
| **Login apenas para administradores** | Só quem publica conteúdo precisa de conta |
| **Modo camuflado e limpeza de histórico** *(planejado)* | Disfarça a interface e apaga rastros de uso |

<br/>

## 🎨 Identidade visual

<p>
  <img src="https://img.shields.io/badge/%2340295F-Roxo-40295F?style=flat-square" alt="#40295F"/>
  <img src="https://img.shields.io/badge/%236E4A66-Malva_escuro-6E4A66?style=flat-square" alt="#6E4A66"/>
  <img src="https://img.shields.io/badge/%23B98A9C-Malva_claro-B98A9C?style=flat-square" alt="#B98A9C"/>
  <img src="https://img.shields.io/badge/%23F25C6E-Emerg%C3%AAncia-F25C6E?style=flat-square" alt="#F25C6E"/>
  <img src="https://img.shields.io/badge/%23F7F1EC-Fundo-F7F1EC?style=flat-square" alt="#F7F1EC"/>
</p>

Tons de roxo e malva, associados ao **Agosto Lilás** e à luta pelo fim da violência contra a mulher. O vermelho é reservado às ações de emergência, para que nunca se confunda com o resto da interface. Tipografia: **Poppins**.

<br/>

## 🗺️ Roadmap

- [x] Estrutura do projeto, repositório e fluxo de branches
- [x] Abertura
- [x] Home com carrossel automático de vídeos
- [x] Barra de navegação inferior compartilhada
- [ ] Emergência — Ligue 180, 190 e Disque 100
- [ ] Informação e Direitos
- [ ] Denúncia com armazenamento local
- [ ] Apoio com geolocalização da rede de atendimento
- [ ] Ajustes, saída rápida e modo camuflado
- [ ] Área administrativa, API REST e banco SQL

<br/>

## 🛠️ Tecnologias

| Camada | Tecnologia |
|---|---|
| Linguagem | Kotlin |
| Interface | Android Views (XML) · ViewBinding · Material Components 3 |
| Componentes | ViewPager2 (carrossel) · Coil (imagens remotas) |
| Build | Gradle Kotlin DSL · minSdk 24 |
| Backend | API REST + banco SQL *(em desenvolvimento)* |
| CI/CD | GitHub Actions — build, testes e APK a cada push |
| Design | Figma |

<br/>

## 🚀 Como executar

**Pré-requisitos:** Android Studio atualizado e um emulador ou aparelho com Android 7.0 (API 24) ou superior.

```bash
git clone https://github.com/MatheusMatiasCoutinho/Vitorias.git
```

1. No Android Studio: **File → Open** e selecione a pasta clonada.
2. Aguarde o **Gradle Sync**.
3. Escolha um dispositivo e clique em **Run ▶**.

> [!TIP]
> Quer só instalar no celular? Cada build da `main` gera um APK: abra a aba **[Actions](https://github.com/MatheusMatiasCoutinho/Vitorias/actions)**, entre no último build verde e baixe **vitorias-debug-apk** em *Artifacts*.

<br/>

## 🤝 Como contribuir

```mermaid
gitGraph
    commit id: "estrutura inicial"
    branch feature/tela-abertura
    commit id: "feat: abertura"
    checkout main
    merge feature/tela-abertura
    branch feature/tela-home
    commit id: "feat: home"
    checkout main
    merge feature/tela-home
```

1. Crie uma branch a partir da `main`: `feature/<nome-da-tela>`
2. Faça commits pequenos, seguindo o padrão abaixo
3. Abra um **Pull Request** para a `main` — nada entra direto nela
4. Aguarde o **GitHub Actions** compilar e testar: PR com build vermelho não entra

| Prefixo | Uso | Exemplo |
|---|---|---|
| `feat` | Nova funcionalidade | `feat: adiciona tela de emergência` |
| `fix` | Correção de bug | `fix: corrige crash ao abrir vídeo` |
| `docs` | Documentação | `docs: atualiza README` |
| `refactor` | Melhoria sem mudar comportamento | `refactor: extrai card de emergência` |
| `chore` | Configuração e manutenção | `chore: atualiza dependências` |

> [!WARNING]
> Nunca commite chaves de API, senhas ou o `local.properties`. Uma chave apagada em commit posterior **continua no histórico** do Git.

<br/>

## 📞 Rede de atendimento

| Canal | Número | Quando usar |
|---|:---:|---|
| Central de Atendimento à Mulher | **180** | Orientação, denúncia e encaminhamento — 24h, gratuito |
| Polícia Militar | **190** | Risco imediato |
| Disque Direitos Humanos | **100** | Violações de direitos humanos |

<br/>

## 👥 Equipe

<table>
  <tr>
    <td align="center" width="160">
      <a href="https://github.com/MatheusMatiasCoutinho">
        <img src="https://github.com/MatheusMatiasCoutinho.png" width="90" alt="Matheus Matias Coutinho"/><br/>
        <sub><b>Matheus Matias Coutinho</b></sub>
      </a><br/>
      <sub><b>Tech Lead</b><br/>Desenvolvedor Android · UI/UX</sub>
    </td>
    <!-- Para adicionar um integrante: copie o bloco <td> acima e troque o usuário do GitHub -->
  </tr>
</table>

<br/>

## 📄 Licença

Distribuído sob a licença **MIT**. Veja [LICENSE](LICENSE).

<br/>

<div align="center">

<img src="docs/logo.png" width="56" alt="Logo Vitórias"/>

<sub>Feito com 💜 por estudantes de Engenharia de Software da **UNICEPLAC**</sub>

<sub><a href="#">⬆ voltar ao topo</a></sub>

</div>
