@echo off

javac -cp ".;lib\mysql-connector-j-9.7.0.jar" thread\Main.java

if errorlevel 1 (
    pause
    exit /b
)

java -cp ".;lib\mysql-connector-j-9.7.0.jar" thread.Main

pause