@ECHO OFF

xcopy /Y .\mock .\src\main\java
xcopy /Y .\input .\src\main\java
del .\src\main\java\README.md

call gradlew.bat test
call gradlew.bat showReport

xcopy /Y .\mock .\src\main\java
