# ParcialT2_Arep2021-1
Este parcial consta de tres partes:
1. La creación de un aplicativo web. 
2. La creación de una imagen en docker correctamente subida en DockerHub.
3. Despliegue del contenedor en una maquina virtual AWS.

### Entendimiento
Se construye una aplicación web pequeña usando el micro-framework de Spark java la cual consta de una pequeña calculadora con dos funciones:

> sin 
> asi 

Una vez tengamos esta aplicación procederemos a construir un container para docker para la aplicación y los desplegaremos y configuraremos en nuestra máquina local. Luego, crearemos un repositorio en DockerHub y subiremos la imagen al repositorio. Finalmente, crearemos una máquina virtual de en AWS, instalaremos Docker , y desplegaremos el contenedor que acabamos de crear.

#### **Prerequisitos**
+ Maven, Java
+ Docker instalado en la máquina
+ Repositorio clonado


# Parte I

## La creación de un aplicativo web
1. Creamos un proyecto java usando maven con el siguiente comando
```
mvn archetype:generate -DgroupId=edu.escuelaing.arep.parcial.spark -DartifactId=Spark -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
2. Creamos la clase principal y la respectiva implementación.

![image](https://user-images.githubusercontent.com/59893804/137206057-ea1a3963-6fa0-40df-9768-43e92d47485e.png)

3. Ejecución y correcto funcionamiento
Ejecutamos el programa con el siguiente comando 
```
mvn clean install 
```
Verificamos el correcto funcionamiento localmente 
> sin 
![image](https://user-images.githubusercontent.com/59893804/137206802-48fbe2a4-045a-40c4-b97e-59e240542f39.png)

> asin 
![image](https://user-images.githubusercontent.com/59893804/137206747-eee30857-47bc-42f8-bfdf-924a2207f9b0.png)

# Parte II
##  La creación de una imagen en docker.
1. Para crear las imágenes, ejecute el siguiente comando.
    ```
    docker build --tag dockerssparcial
    ```
    > En este caso ```dockersparcial``
2. **Verifique que se creo la imagen**
    ```
    docker images
    ```
   ![image](https://user-images.githubusercontent.com/59893804/137207171-5617de63-2e72-4a78-a516-b6045e611a3d.png)

    
    > Puede ingresar a la aplicación de Docker Desktop y revisar que los contenedores, imágenes y/o volúmenes creados, están corriendo.
    
   ![image](https://user-images.githubusercontent.com/59893804/137207514-61443ae7-fc45-4d27-b9d7-512398dca542.png)


    
3. **Apartir de la imagen creada creamos instancias de un contenedor de docker independiente con el siguiente comando**
    ```
    docker run -d -p 34000:6000 --name firstdockercontainer dockersparcial
    ```
    > Podemos crear cuantas se necesiten.
    
4. **Nos aseguramos que el contenedor este corriendo con el comando**
     ```
     docker ps
    ```
    ![image](https://user-images.githubusercontent.com/59893804/137207726-7a4465a1-749a-4acb-a2cd-b5562ed1884c.png)

    
5. **Por ultimo con el siguiente comando generamos automaticamente una configuración docker habiendo creado en el directorio raiz el archivo ``` docker-compose.yml```**
    ``` 
    docker-compose up -d
    ```
6. **El Docker Desktop tiene este resultado**
![image](https://user-images.githubusercontent.com/59893804/137207791-cd90ed8a-ad62-4380-abdc-3d4cef3c1c50.png)

## Upload DockerHub
1. Cree una referencia a su imagen con el nombre del repositorio a donde desea subirla:
    ```
    docker tag dockersparkprimer lina6020/dockerparcialt2
    ```
    ![image](https://user-images.githubusercontent.com/59893804/137208072-a6173f5f-b2f8-4ba3-abb9-c9c0ab6e3fb6.png)

    

2. Ahora se sube las imágenes  a Docker Hub, usando el siguiente bloque de comandos, por cada imagen. Previamente, debe haber creado una cuenta y un repositorio por c/a imagen.
    
    ```
    docker login  --> Realizamos la autenticación
    docker push lina6020/dockerparcialt2:latest --> Empujar imagen al repositorio en Docker Hub
    ```

# Parte III

## Despliegue del contenedor en una maquina virtual AWS.

1. Para el despliegue en aws, debemos tener instala una máquina virtual EC2.A la cual accedemos mediante el protocolo SSH.Ejecutamos el siguiente bloque de código para instalar docker y actualizarla.
    ```sh
    sudo yum update -y
    sudo yum install docker
    ```

2. Posteriormente configuramos nuestro usuario en el grupo de docker, usando los siguientes comandos.
    ```sh
    sudo service docker start
    sudo usermod -a -G docker ec2-user
    ```
![image](https://user-images.githubusercontent.com/59893804/137208606-ea80ba6e-58be-482e-b846-186fd631777a.png)

3. Iniciamos el servicio de docker y a partir de la imagen creada en Dockerhub cree una instancia de un contenedor docker independiente de la consola (opción “-d”) y con el puerto 6000 enlazado a un puerto físico de su máquina (opción -p):
    ```
    docker run -d -p 42000:6000 --name dockersparcialaws lina6020/dockerparcialt2

    ```
    ![image](https://user-images.githubusercontent.com/59893804/137208953-0d69dea5-4a10-4919-b534-cc23ceb65f4a.png)

    
4. Finalmente verificamos que pueda acceder en la url específica de los valores la maquina virtual EC2
    ```
    http://ec2-3-84-43-126.compute-1.amazonaws.com:42000/
    ```    
![image](https://user-images.githubusercontent.com/59893804/137001948-b6bdc15a-105f-4ae9-9ac9-5b8dda64d370.png)

5. Correcto Funcionamiento 

> asin

![image](https://user-images.githubusercontent.com/59893804/137209249-f5f83a7e-3e3b-46c3-a370-a210ed5d9ebd.png)

> sin

![image](https://user-images.githubusercontent.com/59893804/137209342-1f07d37c-8f65-4752-bb67-4677cb500d65.png)

#### **Evidencia del Correcto Funcionamiento**
[![Evidencia](https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/YouTube_full-color_icon_%282017%29.svg/71px-YouTube_full-color_icon_%282017%29.svg.png)](https://www.youtube.com/watch?v=hp0tfZKRiug)
https://www.youtube.com/watch?v=hp0tfZKRiug


## Herramientas utilizadas

| Nombre | Uso |
| ------ | ------ |
| **Maven**  | Gestión y construcción del proyecto |
| **Eclipse IDE**  | Plataforma de desarrollo |
| **Git**  | Sistema de control de versiones |
| **Github** | Respositorio del código fuente |
| **Docker & DockerHub** | Contrucción de los contenedores |
| **Amazon Web Services** | Plataforma de producción en la nube |

## Autor:
Lina Maria Buitrago Espindola

