# WS-SOAP
WS-SOAP es un servicio web (soap) que permite obtener el estado de funcionamiento del servicio AFIP.

##### Prerequisitos
- [Tomcat 9](https://tomcat.apache.org/download-90.cgi)
- [Java 8 (jdk1.8.0_301)](https://www.oracle.com/ar/java/technologies/javase/javase8u211-later-archive-downloads.html)

### Crear proyecto en eclipse

### Setup
#### 1) Crear proyecto
##### 1.1) Clonar este repositorio en su file system. Abrir la consola:
```bash
	cd into eclispe-workspace
	eclispe-workspace>git clone https://github.com/LuisAli22/WS-SOAP.git
```
##### 1.2) En eclipse IDE:
```bash
	file
	Open projects from file system
	En import source, click en directory y elegir la carpeta WS-SOAP que acaba de clonar
	Click en Finish.
```
#### 2) Configurar path de instalación de Tomcat
```bash
	Click con el botón derecho sobre el proyecto, seleccionar properties
```
```bash
	Project facets
	Tildar Dynamic web module 4.0 y java 1.8
	Seleccionar pestaña runtime/ new
	Seleccionar Apache tomcatv9.0/ next
	Seleccionar el path de instalación local de tomcat
	Seleccionar la jre jdk1.8.0_301/ finish
	Click en apply and close
```
#### 3) Crear servidor en eclispe 
##### 3.1)Mostrar consola de servidor en eclipse jee IDE:
```bash
	window
	show view
	servers
```
##### 3.2)Click derecho en la parte vacía de la consola del servidor
```bash
	new
	server
```
```bash
server type: Apache tomcat server 9
server ´s host name: localhost
server name: Tomcat v9.0 Server at localhost
```
###### 3.2.1) Agregar server runtime environment
```bash
Click en add, a la derecha de server runtime environment
```
```bash
	name: Apache tomcat server 9
	Tomcat installation directory: [Path-intalación-tomcat] (ej. C:\Program Files\Apache Software Foundation\Tomcat 9.0)
	Jre: Seleccionar jdk1.8.0_301
	Click en finish
```
##### 3.3) Agregar el recurso WS_SOAP
```bash
	Add WS-SOAP
	Click en finish
```
#### 4) Setear números de puertos
```bash
Doble click con botón izquierdo sobre el servidor recién creado (consola de servidor)
```
```bash
	tomcat admin port; 9000
	HTTP/1.1 port 8080. 
	Guardar la configuracón con CTRL+s (o archivo/guardar)
```
### Ejecución
#### 5) Ejecutar el servidor desde la consola (click en start)
#### 6) (Opcional) Verificar datos del servicio
```bash
	Poner en el navegador http://localhost:8080/WS-SOAP/ws/afipchecker
```
#### 7) Generar peticiones de un cliente
##### 7.1) Instalar [SoapUI](https://www.soapui.org/downloads/soapui/)
##### 7.3) En soapUI crear un nuevo proyecto SOAP (Con el servidor tomcat ejecutándose).
```bash
	Project Name: [NOMBRE DEL PRYOYECTO QUE QUIERAS]
	Initial WSDL: http://localhost:8080/WS-SOAP/ws/afipchecker?wsdl
	Check en create request
```
##### 7.4) Una vez creado el proyecto soap:
```bash
	expandir getStatus
	doble click en Request1
```
##### 7.5) Enviar el pedido al endpoint
```bash
	Click en start (botón verde)
```
#### 8) (Opcional) Verificar almacenamiento del estado de servicio
##### 8.1) Detener el servidor Tomcat. Ir a consola de servidor:
```bash
	Click en stop (botón cuadrado rojo)
```
##### 8.2) Abrir la consola:
```bash
	cd Path-eclispe-workspace/WS-SOAP/src/main/webapp/WEB-INF/lib
	lib> java -cp h2-1.4.199.jar org.h2.tools.Shell -url "jdbc:h2:file:~/data/soap_db" -driver "org.h2.Driver" -user "sql" -password "sql"
```
##### 8.3) Consultar todos los valores de la base de datos (case sensistive, ponerlo tal cual la siguiente línea)
 ```bash
 	sql> select * from afip_checker;
 ```
##### 8.4) Una vez verificado los datos almacenados, para salir del shell
 ```bash
 	sql> exit
 ```
