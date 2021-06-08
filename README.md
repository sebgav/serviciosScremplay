# RetoAutoSophos33

El presente repositorio es usado como base para iniciar la prueba de automatización que esta contemplada dentro del proceso de Certificación para las personas de Calidad.

A continuación se presenta un conjunto de actividades que deben ser contempladas durante la prueba de automatización:


Se crea una rama derivada de master : hamiltontabares

se tiene dos runner que contienen una automatizacion web y un servicio rest

para la parte web se ingresa a una pagina de ventas se adquiere un articulo y se comprueba que se ingreso al carrito

en la parte de servicio se crea un usuario con el metodo post se valida que la respuesta del servicio sea 200 y el usuario creado correctamente

el comando para la ejecucion

gradle clean test aggregate -Dfile.encoding=UTF-8 --info