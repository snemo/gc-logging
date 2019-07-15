# GC logging example

## Java 9+
From Java 9 the JVM logging was finally unified (more info in JEP158). 
To enable gc logging you do not have to set tons flags, but know you can set everything via -Xlog.

     java -Xlog:gc\*=info Application
     
More info Xlog configuration can be found:
    
    java -Xlog:help
    http://openjdk.java.net/jeps/158
    
     
## Before Java 9

    -Xloggc:gc.log
    -XX:+PrintGCDetails
    -XX:+PringGCDateStamps
    -XX:+PrintTenuringDistribution
    -XX:+PrintGCApplicationStoppedTime
    -XX:+PrintClassHistogramAfterFullGC
    -XX:+PrintClassHistogramBeforeFullGC
    -XX:+UseGCLogFileRotation
    -XX:NumberOfGCLogFiles=5
    -XX:GCLogFileSize=20M