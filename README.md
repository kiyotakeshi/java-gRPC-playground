# gRPC

- traditional way(HTTP) problem
    - TCP/IP connection cost
        - three way handshake
        - you need to wait for the request to come back before sending another request where same connection
    - HTTP is stateless
        - Header info is heavy
        - headers are sent in every request
        - plain text
        - can not be compressed
    - serialization & deserialization
        - we understand text format, machines understand binary format
    - API contract
        - we can use OpenAPI, but it's not standard
        - service developer can also provide the claim library(add dependency)
    - Client SDK
        - client use various language

- stubby is RPC Framework from Google
    - this is  tightly coupled with infrastructure...
    - so Google has developed a new Open Source framework gRPC(Remote Procedure Call)

- HTTP/2
    - enable multiplexing, that is one single connection and sending multiple parallel request
        - you don't have to wait for the response to come back
    - binary protocol
    - header compression
        - we don't have to repeat everthing(same information is implicit). we are sending only the changes.

- gRPC
    - HTTP2 is default(binary, multiplexing, flow-conrol)
    - it also provides the bindings for unblocking our streaming operations
    - Protobuf
        - typing auto generated data transfer objects
    - Client's call to the server can be Sync(blocking, wait for the response)/Async

- REST is resource oriented architecture style

- gRPC is more flexible & action oriented

- Protobuf is IDL(interface description language) for API
  - platform and language neutral
  - serializing,deserializing structured data
  - very fast and optimized for inter services communication
  - provides client libraries automatically for many languages

- RPC has four type([RPC life cycle](https://grpc.io/docs/what-is-grpc/core-concepts/#rpc-life-cycle))
  - Unary
    - traditional request,one request and one response

  - Server-streaming
    - one client request and server sent multiple streaming response
    - one to many response model
    - pagination(chunk of huge response, receiving side cannot handle all the response at once)

  - Client-streaming
    - client sends multiple streaming request and server back only one response 
    - file upload(huge file separate small chunk)

  - Bidirectional-streaming

---

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

or [install protobuf cli](https://github.com/protocolbuffers/protobuf/releases/tag/v3.13.0)

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
