# Como ejecutar:
Estuve tratando de ejecutar Junit desde la consola, pero tuve una serie de problemas que me impidieron hacerlo de manera correcta, debido a eso es que explicaré la manera en que logré ejecutarlo.

## IntelliJ IDEA
Este programa lo desarrollé y ejecuté utilizando IntelliJ IDEA. Si deseas descargarlo, puedes hacerlo desde este [link](https://www.jetbrains.com/es-es/idea/download/#section=windows) 
1. Una vez descargado se abre el programa y se va a la seccion File -> Open. 
2. Dentro de la seccion open navega y abre la carpeta Banco.
3. Cuando el IDE te muestre los archivos (Que se encuentra en Banco/src) Abra el archivo Main, vaya a la seccion de Run y seleccione Run (Alt + Shift + F10) eso va a ejecutar la apliacion java.
4. Puede repetir el mismo proceso, pero en vez de elegir main, puede elegir TransaccionTest (Dentro de Banco/tests) de esta manera se ejecutarán los tests. 
5. Si por algun motivo no logra ver la opcion de "Run as Junit Test" es porque se debe añadir Junit5 al build class path, el mismo IDE propone una solucion para eso.


## Eclipse
Tambien probé ejecutar los archivos de este repositorio con el IDE Eclipse. Si deseas descargarlo, puedes hacerlo desde este [link](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2020-06/R/eclipse-inst-win64.exe)
1. Una vez descargado se abre el programa y se va a la seccion File -> Open project from file system. 
2. Dentro de la seccion import source haga click en Directory, y seleccione la carpeta Banco de este repositorio.
3. Una vez se le muestren los archivos dentro del explorador de paquetes haga click derecho en la carpeta de nombre scr, ahi vaya a la opcion que dice "Run as Java Aplication"
4. Si por algun motivo no logra ver la opcion de "Run as Junit Test" es porque se debe añadir Junit5 al build class path, el mismo IDE propone una solucion para eso.

