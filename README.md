# SelecaoMegaPDV

### Este Readme contem a descrição da compilação de projetos WEB feitas por mim (Filipe Cavalcanti).

## 1º Projeto - SudokuRest

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O projeto SudokuRest usa **CSP** (*Constraint Satisfaction Problem*) para implementar o classico jogo Sudoku.</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Descrição do Problema** : sudoku é um jogo de lógica matemática que consiste em nove matrizes onde cada uma delas é formada por nove posições. Cada posição deve ser preenchida por um valor entre 1 e 9, sendo que em cada matriz, linha ou coluna não pode haver números repetidos. Inicialmente cada matriz tem algumas posições preenchidas com valores aleatórios. Alguns desses valores são atribuidos pelo programa no inı́cio de cada partida e os demais são escolhidos pelo agente.</br>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Soluçãoo**: em cada execução, o programa escolhe aleatoriamente quais posições devem ser preenchidas. A quantidade de posições está entre 3 e 5. Os números escolhidos podem ser qualquer um entre 1 e 9. O jogo  exibi a matriz maior e solicita ao usuário em qual matriz menor deverá ocorrer a jogada e em qual posição da matriz deverá ser feita a jogada. Após a escolha da posição, o programa informa quais são os valores que podem ser escolhidos ou se ela já está preenchida. Caso o usuário escolha um valor diferente, o programa não permite a jogada. Quando todas
as posições estão preenchidas, o programa informa quantas jogadas foram realizadas.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Linguagem** : Java (Java EE- JAX-RS  2.0) </br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Padrões de Projeto Utilizados** : 
  * Flyweight;
  * Facade;
  * Singleton;
  * Builder;
  * Factory Method;
  * Memento.</br>
**Servidor** : GlassFish 4.1</br>
**front-end** : HTML5, CSS3, jQUERY, Bootstrap 4;
</br></br>

## 2º Projeto - IFCardio
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp **Descrição do Projeto** : Desenvolver o protótipo de um aparelho multifuncional, para prevenção e tratamento cardíaco, capaz de realizar cinco tipos de exames cardiológicos, o eletrocardiograma de repouso, eletrocardiograma de esforço, looper, holter e monitoramento cardíaco. Os exames serão transmitidos via Internet e o acesso as informações poderão ser acessadas pelo médico especialista por intermédio de smartphone e/ou tablet conectado à internet.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Linguagem** : Python (Django 2.x) </br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Padrões de Projeto Utilizados** : 
  * MVC - Model View Controller. </br></br>
**Servidor**: Apache Tomcat.</br>
**Banco de Dados** : SQLite;
**front-end**: HTML5, CSS3, jQUERY, Bootstrap 4, Google-charts</br></br>

## 3º Projeto - MarketHere
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; A ideia preza desenvolver um sistema onde o usuário possa ter informações detalhadas para fazer suas compras em mercados. Informações como os preços, onde são comparados o mesmo produto em diversos Supermercados e assim obter o preço mais baixo. Outro exemplo de sua aplicação é obter o estabelecimento mais próximo do usuário que possui para a venda os produtos desejados viabilizando compras pequenas e evitando custos desnecessários com locomoção.
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O sistema oferece a criação de grupos para compras compartilhadas, tendo em vista a economia nos valores em compra por volume.</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Os benefícios também podem ser obtidos pelo mercado, como a avaliação dos usuários de seu estabelecimento, obtendo um Feedback para melhorar seus serviços e competitividade. Outro benefício seria a extração do perfil dos compradores em relação aos hábitos de compra, obtendo informações das listas de compras.</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Linguagem** : Java (Java EE - JAX-RS 2.x) </br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Padrões de Projeto Utilizados** : 
  * Data Access Object;
  * Factory Method;
  * Singleton. </br></br>
**Servidor**: GlassFish 4.1 </br>
**Banco de Dados** : PostgreSQL;
#### OBS: Neste Projeto foi desenvolvido apenas o back-end, assim não há nemhuma aplicação front-end para consumir está API REST.
