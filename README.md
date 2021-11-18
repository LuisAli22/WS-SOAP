# WS-SOAP
WS-SOAP Es un servicio web (soap) que permite obtener el estado de funcionamiento del servicio AFIP.

##### Prerequisitos
- Tomcat 9
- JDK 1.8
- Lombok 1.18.22

### Ejecución
#### 1) Crear servidor en eclispe 
##### 1.1) Mostrar consola de servidor en eclipse jee, seleccionar:
```bash
	window/show view/servers
```
##### 1.2) Click derecho en la parte vacía de la consola del servidor
```bash
	new/server/tomcat server 9 y click en next
	Add WS-SOAP/finish
```
##### 1.2) Doble click con botón izquiero sobre el servidor recién creado (consola)
```bash
	Poner el valor tomcat admin port 9000 y HTTP/1.1 el número de puerto que desee (De ahora en adelante APP_PORT)
	Guardar la configuracón con CTRL+s (o archivo/guardar)
```
##### 2) Ejecutar el servidor desde la consola (click en start)
##### 3) Verificar datos del servicio en localhost:APP_PORT/WS-SOAP/ws/afipchecker
