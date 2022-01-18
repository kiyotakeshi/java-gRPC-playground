- create java code

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

- create javascript code

```shell
$ ./target/protoc-plugins/protoc-3.6.1-osx-x86_64.exe --js_out=./ src/main/proto/*proto       

$ ls person.js 
.rw-r--r-- 5.0k kiyotakeshi 18 Jan 22:48 person.js
```

```shell
$ ./target/protoc-plugins/protoc-3.6.1-osx-x86_64.exe --help

  --cpp_out=OUT_DIR           Generate C++ header and source.
  --csharp_out=OUT_DIR        Generate C# source file.
  --java_out=OUT_DIR          Generate Java source file.
  --js_out=OUT_DIR            Generate JavaScript source.
  --objc_out=OUT_DIR          Generate Objective C header and source.
  --php_out=OUT_DIR           Generate PHP source file.
  --python_out=OUT_DIR        Generate Python source file.
  --ruby_out=OUT_DIR          Generate Ruby source file.
```
