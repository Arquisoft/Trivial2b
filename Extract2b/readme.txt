**Pasos para arrancar el Trivial con MongoDB
-Descargar e instalar MongoDB
-Crear un direction que servirá de respaldo a la BBDD --> md \data\db
-Arrancar la BBDD en local --> mongod (desde linea de comando desde la capeta
	bin del MongoDB)
-Cargar el JSON desde otra linea de comandos (con BBDD desplegada en local, 
	mongod) --> mongoimport -d Preguntas -c Preguntas --file preguntasFromXML.json --jsonArray
-Comprobamos que se a cargado --> mongo (para despliege de shell de mongoDB) --> mongo Preguntas --> show dbs

**Pasos para configurar projecto Maven
-Descargar .jar mongo-java-driver-2.9.3-javadoc y referenciarlo.
