@echo off
set JAR=C:\Users\Acer\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\4.1.0\spring-boot-autoconfigure-4.1.0.jar
jar tf "%JAR%" | C:\Windows\System32\findstr.exe /i flyway
echo EXIT=%ERRORLEVEL%
