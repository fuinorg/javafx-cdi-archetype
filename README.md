# javafx-cdi-archetype
JavaFX with CDI Archetype

![Build](https://github.com/fuinorg/javafx-cdi-example/actions/workflows/maven.yml/badge.svg)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.fuin.archetypes/javafx-cdi-archetype/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.fuin.archetypes/javafx-cdi-archetype/)
[![LGPLv3 License](http://img.shields.io/badge/license-LGPLv3-blue.svg)](https://www.gnu.org/licenses/lgpl.html)
[![Java Development Kit 11](https://img.shields.io/badge/JDK-11-green.svg)](https://openjdk.java.net/projects/jdk/11/)

Use this archetype to bootstrap your own project based on the [javafx-cdi-example](https://github.com/fuinorg/javafx-cdi-example).

> :warning: There is currently a bug with the `.gitignore` during archetype generation. You need to manually copy the provided [](archetype/src/main/resources/archetype-resources/.gitignore) to the root of the newly generated project.

## Generate your project

### Mandatory Parameters
```
mvn archetype:generate \
     -DarchetypeGroupId=org.fuin.archetypes \
     -DarchetypeArtifactId=javafx-cdi-archetype \
     -DarchetypeVersion=0.1.0
```

### All Parameters
```
mvn archetype:generate \
    -DarchetypeGroupId=org.fuin.archetypes \
    -DarchetypeArtifactId=javafx-cdi-archetype \
    -DarchetypeVersion=0.1.0 \
    -DgroupId="com.mycompany" \
    -DartifactId="myapp" \
    -Dversion="0.1.0-SNAPSHOT" \
    -DpkgPath="com/mycompany/myapp" \
    -Ddescription="My cool application" \
    -DhyphenName="my-cool-app" \
    -DmainName="MyCoolApp"
```

**Explanation**
<table border="1" style="font-size:0.9em; text-align:left; vertical-align:top; padding-top:5px; padding-bottom:4px;">
<tr><th>Parameter</th><th>Default Value</th><th>Description</th></tr>
<tr><td>groupId</td><td>com.mycompany</td><td>Maven 'groupId' of your application</td></tr>
<tr><td>artifactId</td><td>myapp</td><td>Maven 'artifactId' of your application</td></tr>
<tr><td>version</td><td>0.1.0-SNAPSHOT</td><td>Maven 'version' of your application</td></tr>
<tr><td>packagePath</td><td>com/mycompany/myapp</td><td>The base Java package as path</td></tr>
<tr><td>description</td><td>My cool application</td><td>A brief description of your application</td></tr>
<tr><td>hyphenName</td><td>my-cool-app</td><td>A short name for your application. Only lower case characters 'a'-'z' and '-' are allowed.</td></tr>
<tr><td>mainName</td><td>MyCoolApp</td><td>The main class name of your application. Must be a valid Java class name. Most likely the 'hyphenName' as Camel Case.</td></tr>
</table>

* * *

## Snapshots

Snapshots of this archetype can be found in the **OSS Sonatype Snapshots Repository**. 

Add the following to your .m2/settings.xml to enable snapshots in your Maven build:

```xml
<repository>
    <id>sonatype.oss.snapshots</id>
    <name>Sonatype OSS Snapshot Repository</name>
    <url>http://oss.sonatype.org/content/repositories/snapshots</url>
    <releases>
        <enabled>false</enabled>
    </releases>
    <snapshots>
        <enabled>true</enabled>
    </snapshots>
</repository>
```
