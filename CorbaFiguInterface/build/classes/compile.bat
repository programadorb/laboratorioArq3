:: Directorio de java SDK
SET JAVA_HOME="D:\jdk1.8.0_181"
:: direccion de las fuentes SRC de proyecto netbeans IDL "CorbaFiguInterface"

SET PATH_IDL="C:\Users\dani\Documents\NetBeansProjects\LabCorba\CorbaFiguInterface\src\"
:: nombre del archivo IDL
SET IDL_NAME=figunacci.idl
:: comando para compilar
%JAVA_HOME%\bin\idlj -fall -td %PATH_IDL% %PATH_IDL%\%IDL_NAME%

::idlj -fall -td . figure.idl