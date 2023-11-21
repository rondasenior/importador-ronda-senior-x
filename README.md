# Configurar Java 11 e Maven
* Baixar o [Java 11](https://jdk.java.net/archive/)
* Baixar o [Maven](https://maven.apache.org/install.html)

É necessário adicionar ambos nas variáveis de ambiente, para isso sugiro consultar o site da [Medium](https://medium.com/beelabacademy/configurando-vari%C3%A1veis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26)


# IDE
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

# Criando chave SSH
* Segue passoa para gerar chave SSSH e inclui-la no sourcetree:
1. Criar chave SSH utiizando e-mail da conta do github: </br>
<img width="426" alt="Screenshot_2" src="https://github.com/rondasenior/importador-ronda-senior-x/assets/48299447/65372c33-3558-4e97-a9a4-96c9b02a5af7">
</br>
2.  Inserir chave SSH no sourcetree: </br>
<img width="285" alt="incluindo chave no sourcetree parte 1" src="https://github.com/rondasenior/importador-ronda-senior-x/assets/48299447/5d854146-3518-4cc7-98ac-2e58ebe09d10">
</br>
<img width="477" alt="incluindo chave no sourcetree parte 2" src="https://github.com/rondasenior/importador-ronda-senior-x/assets/48299447/84bef9f2-b0bf-42ae-852c-9e3771e6bb84">
</br>
3.  Configurar repositório para clonar o projeto utilizando o link SSH: </br>
<img width="299" alt="repositorio sourcetree" src="https://github.com/rondasenior/importador-ronda-senior-x/assets/48299447/d3a0b47b-08e8-4c1c-8cfc-05fb7c7505e2">
</br>
4.  Commitar as alterações a criar pull request no github; </br>
5.  Associar um viewer para aprovar o pull request; </br>
6.  Solitar para alguém com permissão de executar merge para mergear o pull request aprovado. </br>

# Gerando o JAR
* Somente depois de tudo comitado que deve-se iniciar o processo de geração do jar
* Para gerar o JAR vá no pom principal:
    * Alterar a tag principal **<version>** do pom para o padrão de [versionamento semântico](https://imasters.com.br/codigo/versionamento-semantico-o-que-e-e-como-usar#:~:text=Essa%20regra%20define%20basicamente%20o,dever%C3%A1%20sempre%20iniciar%20com%201.)
    * Alterado, não esquecer de alterar o changelog conforme o padrão dentro do arquivo  _CHANGELOG.md_
    * No pom com o botão direito selecione Run As -> Maven clean
    * Após isto com o botão direito ir em Run As -> Maven build...
    * Quando aberto a janela do Maven build em "Goals" escrever "package", dar um Apply e logo após Run
    * Com isso o JAR será criado com as depêndencias dentro da pasta target do seu projeto
    * Após finalizar tudo será necessário colocar o JAR "importador-ronda-senior-x-{version}.jar" dentro da pasta ``jar`` que se encontra na raiz do projeto, remover o jar antigo e comitar
    


