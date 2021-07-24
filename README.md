# send-email
##### *Microserviço de envio de email, com template da sendgrid*


## 💻 Executar na máquina local 
* Primeiramente, faça o clone do repositório:

```
    https://github.com/NeiltonA/send-email.git
```
* Feito isso, acesse o projeto:

```
cd send-email
```
* É preciso compilar o código e baixar as dependências do projeto:

```
mvn clean package
```
* Finalizado esse passo, vamos iniciar a aplicação:

```
mvn spring-boot:run
```
* Pronto. A aplicação está disponível em `http://localhost:8080`

# 🐋 Executar via [Docker](https://www.docker.com/) 
 * Com um arquivo Maven configurado corretamente, podemos criar um arquivo jar executável.
 
 ```
 mvn clean package
```
### 📋 Pré-requisitos
* Instalar o *DOCKER* na máquina


* Para criar uma imagem de nosso Dockerfile, temos que executar o `docker build` , como antes:


 ```
  docker build --tag=send-email:latest 
 ```

* Por fim, podemos executar o contêiner a partir de nossa imagem:

    docker run -p8887:8888 send-email:latest
	

* Se executarmos o contêiner no modo desanexado, podemos inspecionar seus detalhes, interrompê-lo e removê-lo com os seguintes comandos:

	
	docker inspect send-email
    docker stop send-email
    docker rm send-email
    

# 🐋 Executar via [Docker-compose](https://www.docker.com/)
* Antes de continuarmos, verificaremos nosso arquivo de compilação em busca de erros de sintaxe:

	docker-compose config

* Finalmente, podemos construir nossas imagens, criar os contêineres definidos e iniciá-los em um comando:

	docker-compose up --build


* Para interromper os contêineres.
 
   ```
   docker-compose down
   ```
   
	
## ✒️ Autor
* Ney