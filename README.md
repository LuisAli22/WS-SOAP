# WS-SOAP
WS-SOAP Es un servicio web (soap) que permite obtener el estado de funcionamiento del servicio AFIP.

##### Prerequisitos
- Tomcat 9
- JDK 1.8
- Lombok 1.18.22

### Ejecuci�n
#### 1) Crear servidor en eclispe 
##### 1.1) Mostrar consola de servidor en eclipse jee, seleccionar:
```bash
	window/show view/servers
```
##### 1.2) Click derecho en la parte vac�a de la consola del servidor
```bash
	new/server/tomcat server 9 y click en next
	Add WS-SOAP/finish
```
##### 1.2) Doble click con bot�n izquiero sobre el servidor reci�n creado (consola)
```bash
	Poner el valor tomcat admin port 9000 y HTTP/1.1 el n�mero de puerto que desee (De ahora en adelante APP_PORT)
	Guardar la configurac�n con CTRL+s (o archivo/guardar)
```
##### 2) Ejecutar el servidor desde la consola (click en start)
##### 3) Verificar datos del servicio en localhost:APP_PORT/WS-SOAP/ws/afipchecker
