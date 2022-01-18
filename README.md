```shell
$ export JAVA_HOME=`/usr/libexec/java_home -v 11`

$ java -version
openjdk version "11.0.8" 2020-07-14
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.8+10)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.8+10, mixed mode)

$ mvn clean compile

$ \ls target/generated-sources/protobuf/java/com/kiyotakeshi/models/Person*   
target/generated-sources/protobuf/java/com/kiyotakeshi/models/Person.java
target/generated-sources/protobuf/java/com/kiyotakeshi/models/PersonOrBuilder.java
target/generated-sources/protobuf/java/com/kiyotakeshi/models/PersonOuterClass.java
```
