**Pasos para arrancar juego Trivial2b
-Arrancar HSQLDB (startup.bat)
-Arrancar Mongo (version mongodb-win32-x86_64-2008plus-2.6.9)
	+ md \data\db
	+ mongod
-Importar como Maven Proyect la carpeta "Trivial2b"
-Arrancar como aplicacion "Menuprincipal.java" del paquete "gui"
-Una vez arracada la aplicaci�n...
	+Cargar preguntas como admin (los .gift necesarios donde se 
		encuentran las preguntas estan en el paquete "resources")
	+Crear una nueva cuenta de usuario o usar las ya existentes en la 
		base de datos hsqld (hay una cuenta por cada miembro del equipo
		donde el nombre de usuario es nombre de cada miembro, haciendo
		coincidir el nombre de usuario con la contrase�a)
	+Crear una nueva partida donde las categorias seleccionadas deben ser 
		aquellas que cargamos anteriormente desde admin (si una categoria
		esta seleccionada y no cargada, mostrar� un mensaje de error al usuario).
		Y con los usuarios que jugar�n la partida.
-Lanzar el dado y ya comienza la partida con el primer usuario.
