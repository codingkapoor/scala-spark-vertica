# scala-spark-vertica
Project to demonstrate loading vertica data into spark dataframes

### Unmanaged Dependencies
So as to enable our application to be able to connect to vertica we need to include two JARs, which comes packaged with spark binary, as unmanaged dependencies in our SBT project, since they are not available on maven repositories. 

These jars could be found at following locations:
  1. Vertica Connector (`/opt/vertica/packages/SparkConnector/lib/vertica-spark2.1_scala2.11.jar`)
  2. Vertica JDBC Driver (`/opt/vertica/java/vertica-jdbc-10.0.0-0.jar`)
  
#### Add Unmanaged Dependencies
1. Copy jars to the `lib` directory under project root directory
2. Add the following lines in `build.sbt`
```
unmanagedJars in Compile ++= Seq(
  baseDirectory.value / "lib/vertica-spark2.1_scala2.11.jar",
  baseDirectory.value / "lib/vertica-jdbc-10.0.0-0.jar"
)
```

### Create Data In Vertica
The app is based on the following data in vertica. Create a `test` table in vertica and add couple of dummy entries as follows:
```
=> CREATE TABLE test (a int, b int, c int, d varchar);
=> INSERT INTO test VALUES (1, 3, 5, 'odds');
=> INSERT INTO test VALUES (10, 14, 8, 'evens');
=> INSERT INTO test VALUES (11, 13, 19, 'odds');
=> COMMIT;
```
