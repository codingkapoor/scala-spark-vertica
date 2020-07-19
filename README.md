# scala-spark-vertica
Project to demonstrate loading vertica data into spark dataframes

## Unmanaged Dependencies
So as to enable our application to be able to connect to vertica we need to include two JARs, which comes packaged with spark binary, as unmanaged dependencies in our SBT project, since they are not available on maven repositories. These jars could be found at following locations:

  1. Vertica Connector (`/opt/vertica/packages/SparkConnector/lib/vertica-spark2.1_scala2.11.jar`)
  2. Vertica JDBC Driver (`/opt/vertica/java/vertica-jdbc-10.0.0-0.jar`)
