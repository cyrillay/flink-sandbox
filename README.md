## A simple Flink batch application using Scala and SBT.

To run and test locally, execute `sbt run` then select the main class that contains the Flink job. 
It is also possible to package the application into a fat jar with `sbt assembly`, then submit it with :
```
flink run target/scala-2.11/flink-project-assembly-0.1-SNAPSHOT.jar
```

You can also run your application from within IntelliJ:  select the classpath of the 'mainRunner' module in the run/debug configurations.
Simply open 'Run -> Edit configurations...' and then select 'mainRunner' from the "Use classpath of module" dropbox. 
