test -d "src/main/java" || mkdir -p "src/main/java" && cp mock/* src/main/java
test -d "src/main/java" || mkdir -p "src/main/java" && cp input/* src/main/java

rm src/main/java/README.md

./gradlew test
./gradlew showReport

cp mock/* src/main/java