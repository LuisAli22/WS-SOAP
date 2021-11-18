# WS-SOAP
WS-SOAP es un servicio web (soap) que permite obtener el estado de funcionamiento del servicio AFIP.

##### Prerequisitos
- Tomcat 9
- JDK 1.8
- Lombok 1.18.22

### Ejecuci�n
#### 1) Configurar path de instalaci�n de Tomcat
##### 1.1) Click con el bot�n derecho sobre el proyecto/ properties
```bash
	Project facets- seleccionar pesta�a runtime/ new
	Seleccionar Apache tomcatv9.0/ next
	Seleccionar el path de instalaci�n local de tomcat
	Seleccionar la jre por defecto en el workspace/ finish
	CLick en apply and close
```

#### 2) Crear servidor en eclispe 
##### 2.1) Mostrar consola de servidor en eclipse jee, seleccionar:
```bash
	window/show view/servers
```
##### 2.2) Click derecho en la parte vac�a de la consola del servidor
```bash
	new/server/tomcat server 9
	Elegir Server runtime environment al runtime creado en el paso 1.1. Click en next.
	Add WS-SOAP/finish
```
##### 2.3) Doble click con bot�n izquierdo sobre el servidor reci�n creado (consola)
```bash
	Poner el valor tomcat admin port 9000 y HTTP/1.1 el n�mero de puerto que desee. 
	(De ahora en adelante APP_PORT).
	Guardar la configurac�n con CTRL+s (o archivo/guardar)
```
##### 3) Ejecutar el servidor desde la consola (click en start)
##### 4) Verificar datos del servicio en http://localhost:APP_PORT/WS-SOAP/ws/afipchecker
