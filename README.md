# WS-SOAP
WS-SOAP es un servicio web (soap) que permite obtener el estado de funcionamiento del servicio AFIP.

##### Prerequisitos
- Tomcat 9
- JDK 1.8
- Lombok 1.18.22

### Ejecución
#### 1) Configurar path de instalación de Tomcat
##### 1.1) Click con el botón derecho sobre el proyecto/ properties
```bash
	Project facets- seleccionar pestaña runtime/ new
	Seleccionar Apache tomcatv9.0/ next
	Seleccionar el path de instalación local de tomcat
	Seleccionar la jre por defecto en el workspace/ finish
	CLick en apply and close
```

#### 2) Crear servidor en eclispe 
##### 2.1) Mostrar consola de servidor en eclipse jee, seleccionar:
```bash
	window/show view/servers
```
##### 2.2) Click derecho en la parte vacía de la consola del servidor
```bash
	new/server/tomcat server 9
	Elegir Server runtime environment al runtime creado en el paso 1.1. Click en next.
	Add WS-SOAP/finish
```
##### 2.3) Doble click con botón izquierdo sobre el servidor recién creado (consola)
```bash
	Poner el valor tomcat admin port 9000 y HTTP/1.1 el número de puerto que desee. 
	(De ahora en adelante APP_PORT).
	Guardar la configuracón con CTRL+s (o archivo/guardar)
```
##### 3) Ejecutar el servidor desde la consola (click en start)
##### 4) Verificar datos del servicio en http://localhost:APP_PORT/WS-SOAP/ws/afipchecker
