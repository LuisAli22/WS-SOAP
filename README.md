# WS-SOAP
WS-SOAP Es una aplicacion que tiene como finalidad funcionar como una API-SOAP que consume un servicio de la AFIP para luego convertirse en un servicio SOAP,
que seria consumida por una API-REST.   
Esta siendo desarrollado por el equipo "Training-Workshop" conformado por Daniel, luis y Matias, siendo estos supervisados por Horacio Perez.

##### Prerequisitos
- Github
- JAX-WS
- JDK <= 8

### Ejecución
##### 1. Ejecutar como aplicación de java
##### 2. Verificar http://localhost:8080/ws/afipchecker?wsdl
##### 3. Utilizar la operación getStatus() ofrecida por la interfaz AfipServiceChecker
