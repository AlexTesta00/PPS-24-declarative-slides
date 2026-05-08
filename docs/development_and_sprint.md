# Sviluppo Iterativo e Sprint
Pur non essendo stato formalizzato come Scrum rigoroso, il progetto è stato chiaramente sviluppato per fasi incrementali.

| **Sprint/Fase** | **Obiettivo** | **Risultato** | **Criticità** | **Valore prodotto** |
| --- | --- | --- | --- | |
| Fase 1 | modellazione dominio e DSL base| presentazione, slide, testo, bullet, codice| definizione dei vincoli| base concettuale del sistema
| Fase 2 | renderer HTML e testo| output multipli| separazione fra modello e vista | validazione del design multi-renderer
| Fase 3 | CLI e orchestrazione | esecuzione da terminale| gestione errori e bootstrap| usabilità reale del progetto
| Fase 4 | refactor architetturali|	parser, factory, utility, error handling | evitare opacità| maggiore manutenibilità
| Fase 5 | immagini, footer, Markdown |	nuove estensioni funzionali| mantenere coerenza del dominio| dimostrazione di estendibilità
| Fase 6 | Documentazione | pubblicazione su Pages | coordinamento con release| comunicazione e accessibilità del progetto

## Tabella di dettaglio

| Id | Item | Stima (h) | Effettivo (h) | S1 | S2 | S3 | S4 | S5 |
|----|------|-----------|---------------|----|----|----|----||
| 1 | Setup repository e convenzioni di versionamento | 2 | 3 | 3 | 0 | 0 | 0 | 0 |
| 2 | Setup sbt, dipendenze e framework base | 3 | 5 | 5 | 0 | 0 | 0 | 0 |
| 3 | Setup CI multi-OS con GitHub Actions | 3 | 5 | 4 | 1 | 0 | 0 | 0 |
| 4 | Setup qualità: formatter, linter/scalafix, coverage e Codecov | 3 | 5 | 3 | 2 | 0 | 0 | 0 |
| 5 | Modellazione del dominio e regole di validazione | 5 | 8 | 5 | 3 | 0 | 0 | 0 |
| 6 | DSL base e modello di composizione delle slide | 6 | 9 | 4 | 5 | 0 | 0 | 0 |
| 7 | Application layer, bootstrap ed esecuzione con Scala CLI | 5 | 8 | 0 | 6 | 2 | 0 | 0 |
| 8 | CLI, parsing argomenti, gestione errori e UX da terminale | 4 | 6 | 0 | 5 | 1 | 0 | 0 |
| 9 | Renderer testuale | 3 | 4 | 0 | 3 | 1 | 0 | 0 |
| 10 | Renderer HTML e navigazione della presentazione | 5 | 9 | 0 | 4 | 5 | 0 | 0 |
| 11 | Renderer Markdown | 3 | 4 | 0 | 0 | 4 | 0 | 0 |
| 12 | Supporto a immagini e footer nel DSL e nei renderer | 5 | 7 | 0 | 0 | 5 | 2 | 0 |
| 13 | Refactor per estendibilità, pulizia package e separazione responsabilità | 4 | 5 | 0 | 0 | 3 | 2 | 0 |
| 14 | Estensione suite di test, TDD hardening e regressioni | 4 | 6 | 0 | 0 | 0 | 5 | 1 |
| 15 | Documentazione tecnica, sito di presentazione, Pages deploy e release automation | 5 | 6 | 0 | 0 | 0 | 3 | 3 |
| **TOT** |  | **60** | **90** | **24** | **29** | **21** | **12** | **4** |

## Tabella di riepilogo

| Fase | Attività principali | Stima (h) | Effettivo (h) | Scostamento |
|------|---------------------|-----------|---------------||
| Analisi | comprensione del dominio, definizione obiettivi, requisiti iniziali | 8 | 12 | +4 |
| Progettazione | architettura, organizzazione package, modellazione DSL e dominio | 12 | 18 | +6 |
| Setup tecnico | repository, sbt, framework, CI, coverage, formatter, linter | 10 | 16 | +6 |
| Implementazione core | DSL, dominio, application layer, CLI | 14 | 20 | +6 |
| Rendering | HTML, text, Markdown, immagini, footer | 8 | 12 | +4 |
| Testing e refactor | TDD, regressioni, pulizia architetturale, manutenzione | 4 | 7 | +3 |
| Documentazione e presentazione | Scaladoc, sito, immagini, relazione, deploy Pages | 4 | 5 | +1 |
| **TOT** |  | **60** | **90** | **+30** |