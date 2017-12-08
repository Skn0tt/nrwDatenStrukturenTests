@ECHO OFF

xcopy /Y /I .\mock .\src\main\java
xcopy /Y /I .\input .\src\main\java
del .\src\main\java\README.md

call gradlew.bat test
call gradlew.bat showReport

xcopy /Y /I .\mock .\src\main\java
