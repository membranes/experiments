<br>

**Experiments**

<br>

## Notes

* [Spark Configuration](https://spark.apache.org/docs/latest/configuration.html)

The focus herein is _configuring for computation_; study [ExperimentsApp](src/main/scala/ExperimentsApp.scala).  Examples 
include the # of shuffle partitions for joins & aggregation:

> ```scala
> spark.conf.set("spark.sql.shuffle.partitions", String)
> ```

The default # of partitions delivered after a transformation:

> ```scala
> spark.conf.set("spark.default.parallelism", String)
> ```

Speculative execution $\rightarrow$ if true "performs speculative execution of tasks. This means if one or more tasks are
running slowly in a stage, they will be re-launched."

> ```scala
> spark.conf.set("spark.speculation", Boolean)
> ```

<br>

## Project

Directory Structure:
  * [sbt](https://www.scala-sbt.org/1.x/docs/Directories.html)
  * [maven](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)

<br>

### SBT (Scala Build Tool)

* [sbt plugins](https://www.scala-sbt.org/1.x/docs/Community-Plugins.html)
* [sbt assembly](https://github.com/sbt/sbt-assembly)
  * [example](https://www.baeldung.com/scala/sbt-fat-jar)
  * [discussion](https://alvinalexander.com/scala/sbt-how-build-single-executable-jar-file-assembly/)
  * [packaging](https://www.baeldung.com/scala/package-app)
* [sbt build information](https://github.com/sbt/sbt-buildinfo#latest-stable)
  * [example](https://www.baeldung.com/scala/sbt-generate-build-info)


<br>


### Maven

* [settings](https://maven.apache.org/settings.html)
* [classpath](https://maven.apache.org/shared-archives/maven-archiver-2.5/examples/classpath.html)

* [scala & maven](https://docs.scala-lang.org/tutorials/scala-with-maven.html)
* [.jar](https://docs.scala-lang.org/tutorials/scala-with-maven.html#creating-a-jar)
* [maven compiler plugin](https://maven.apache.org/plugins/maven-compiler-plugin/usage.html)


<br>


## Snippets

```shell
mvn -Pconnect -DskipTests clean package
```

```shell
spark-submit --class pattern.intelligence.FociApp --master local[2] \
	target/foci-...-jar-with-dependencies.jar 
```


<br>
<br>

<br>
<br>

<br>
<br>

<br>
<br>
