### Configurar Java 11 e Maven
* Baixar o [Java 11](https://jdk.java.net/archive/)
* Baixar o [Maven](https://maven.apache.org/install.html)

É necessário adicionar ambos nas variáveis de ambiente, para isso sugiro consultar o site da [Medium](https://medium.com/beelabacademy/configurando-vari%C3%A1veis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26)


### IDE
* Baixar o [Eclipse](https://www.eclipse.org/downloads/)
* Após abrir o Eclipse sugerimos instalar o WindowBuilder, para isso:
    * No menu acesse Help -> Eclipse Marketplace...
    * Na janela que se abre, pesquise por "windowbuilder" e instale o mesmo
* Para importar o projeto vá em File -> Import:
    * Pesquise por "Existing Maven Projects" e selecione
    * Procure por seu projeto do importador baixado do git e dê um Finish
* Após seu projeto estar no Eclipse:
    * No pom principal clicar com o botão direito
    * Selecionar Run As -> Maven build...
    * Quando aberto a janela do Maven build em "Goals" escrever "clean install", dar um Apply e logo após Run
    * Depois, no projeto principal, clicar com o botão direito escolhe a opção Maven -> Update Project...
    * Quando aberto a janela do Update Project, marcar a opção "Force Update of Snapshots/Releases" e dar um OK
* Quando finalizado estes processos, basta ir na classe ImportadorRondaSeniorXApplication clicar com o botão direito, Run As -> Java Application e seu projeto será executado

**Sugerimos que na classe RestService troque as URLs(urlSAM e urlSSecure) para aportar para seu ambiente**


### Gerando o JAR
* Para gerar o JAR vá no pom principal:
    * Com o botão direito selecione Run As -> Maven clean
    * Após isto com o botão direito ir em Run As -> Maven build...
    * Quando aberto a janela do Maven build em "Goals" escrever "package", dar um Apply e logo após Run
    * Com isso o JAR será criado com as depêndencias
    * Após finalizar tudo será necessário colocar o JAR "importador-ronda-senior-x-0.0.1-SNAPSHOT.jar" dentro da pasta jar que se encontra na raiz do projeto e comitar
