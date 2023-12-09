# javafx-cdi-archetype
Generates the JavaFX CDI Example Application Archetype.

## Usage
See detailed description on how to use it: [archetype](archetype).

## Modules
- **[archetype](archetype)** - The generated Maven Archetype project. This will be used to bootstrap a new project via `mvn archetype:generate` plus some parameters.
- **[example](example)** - The source example project to create a Maven Archetype from.
- **[marchetyper](marchetyper)** - The plugin that converts from example to archetype.

## Build
In the root directory simply run a maven build:
```
mvn clean install
```

This will delete the content of the [archetype](archetype) directory and recreate it with the converted content of the [example](example) project.

The conversion is configured with the [marchetyper-config.xml](marchetyper/marchetyper-config.xml) file.

