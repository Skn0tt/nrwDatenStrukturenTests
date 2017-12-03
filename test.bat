@ECHO OFF

xcopy /y .\input .\src\main\java
del .\src\main\java\README.md

call gradlew.bat test
call gradlew.bat showReport