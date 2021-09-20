# Prova Técnica DBC
Este arquivo possui como objetivo apresentar ao público duas aplicações. A primeira aplicação é uma automação em página Web realizada utilizando o framework RobotFramework e a biblioteca Selenium na linguagem de programação Python, a segunda aplicação é uma automação de API utilizando as bibliotecas Restassured e Testng. No decorrer do documento serão dados mais detalhes acerca de cada projeto.

## Configurações do sistema
* Ubuntu 20.04 LTS
* Intel® Core™ i5-3337U
* 8GB RAM

## Desafio 01 (RobotFramework)
* Dependências
* Como instalar
* Como executar
* Interpretando o relatório

## Dependências

- [ ] Visual Studio Code (Opcional) 
- [ ] Python 3.8.10
- [ ] Gerenciador Pip 
- [ ] RobotFramework
- [ ] Selenium Library
- [ ] Chromedriver
- [ ] Plugins   

## Desafio 01: Como instalar
O tutorial será direcionado para execução no sistema operacional Ubuntu, visto que este foi o sistema utilizado pelo autor para execução dos testes.
### Python 3.8.10 e Gerenciador Pip
Normalmente o Python já vem instalado nativamente na máquina Ubuntu. Mesmo assim, é interessante realizar a checagem da linguagem no terminal através do comando:
```bash
which python3
```
que deve retornar algo como:
```/usr/bin/python3```
.Caso haja algum erro relacionado à instalação do python, você pode instalar o mesmo através do comando Apt-get:
```bash
sudo apt-get install python3
```
No caso do Pip, você pode verificar a versão atual presente no sistema através do comando ```pip --version```, caso o gerenciador de pacotes não tenha sido instalado juntamento ao python, você pode instalar ele através do comando:
```bash
sudo apt-get install python3-pip
```

### Visual Studio Code
O Visual Studio Code (vscode) foi o editor escolhido pelo desenvolvedor para o desenvolvimento da aplicação de automação web, mas você está livre para usar o editor de sua preferência para realizar o mesmo processo. Caso você não possua o editor instalado na sua máquina, é possível instalar facilmente através do comando:
```bash
sudo snap install --classic code
```
### RobotFramework
A instalação do robotframework é realizada através do gerenciador de pacotes pip, então no terminal ubuntu você pode estar realizando a instalação através do comando:
```bash
pip install robotframework
```

### Selenium Library
O robotframework traz algumas bibliotecas por padrão em sua instalação e outras que precisam ser baixadas através do pip, como é o caso da Selenium Library. Sendo assim, caso você não tenha instalado o comando é:
```bash
pip install --upgrade robotframework-seleniumlibrary
```

### Webdriver
Para realizar o teste de um sistema Web através de um navegador é necessário ter instalado o webdriver do navegador a ser utilizado, no caso deste projeto o navegador escolhido foi o Google Chrome. Para realizar a instalação, primeiramente é necessário saber qual a versão atual do seu navegador chrome
### Plugins

## Desafio 02: Maven
* Dependências
* Como executar
* Interpretando o relatório


## Bugs Identificados




