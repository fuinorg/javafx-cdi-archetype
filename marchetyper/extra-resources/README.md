# JavaFX CDI Example Application Archetype
Archetype that creates a new JavaFX CDI Example Application Maven project.

## Generate

### Mandatory Parameters
```
mvn archetype:generate \
     -DarchetypeGroupId=org.fuin.archetypes \
     -DarchetypeArtifactId=javafx-cdi-archetype \
     -DarchetypeVersion=0.2.0-SNAPSHOT
```

### All Parameters
```
mvn archetype:generate \
     -DarchetypeGroupId=org.fuin.archetypes \
     -DarchetypeArtifactId=javafx-cdi-archetype \
     -DarchetypeVersion=0.2.0-SNAPSHOT \
     -DgroupId="com.mycompany" \
     -DartifactId="myapp" \
     -Dversion="0.2.0-SNAPSHOT" \
     -DpkgName="com.mycompany.myapp" \
     -DappName="MyCoolApp"
```

### Explanation

| Variable     | Default                    | Description                  |
|:-------------|:---------------------------|:-----------------------------|
| groupId      | com.mycompany              | Your app's Group ID         |
| artifactId   | myapp                      | Your app's Artifact ID      |
| version      | 0.1.0-SNAPSHOT             | Your app's version          |
| pkgName      | com.example.archetypes.abc | The base package of your app |
| appName      | MyCoolApp                  | Camelcase name of your app   |

### Tips
In case you're developing a new version of this archetype, and you want to build and test it locally, you need to tell Maven about it:
```
mvn archetype:generate \
     -DarchetypeGroupId=org.fuin.archetypes \
     -DarchetypeArtifactId=javafx-cdi-archetype \
     -DarchetypeVersion=0.2.0-SNAPSHOT \
     ...
     -DarchetypeCatalog=local
```
The `-DarchetypeCatalog=local` enables Maven to use the locally installed Archetype.
