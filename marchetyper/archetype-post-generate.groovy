import java.nio.file.Path
import java.nio.file.Paths

println "[INFO] Executing archetype-post-generate.groovy script...";

Path projectPath = Paths.get(request.outputDirectory, request.artifactId)
println "[INFO] projectPath: " + projectPath;

Properties properties = request.properties
println "[INFO] properties: " + properties;

File fileDir = projectPath.toFile();
fileDir.eachFileRecurse() { file ->
    if (file.getName().startsWith("_.")) {
        File targetFile = new File(file.getParentFile(), file.getName().substring(1));
        println "[INFO] Rename dot file " + file + " to " + targetFile;
        file.renameTo(targetFile);
    }
}
