cp input/* src/main/java

rm src/main/java/README.md

./gradlew test
./gradlew showReport