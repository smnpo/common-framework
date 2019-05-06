set VERSION=1.0-SNAPSHOT
set PROJECT=smnpo-springboot-parent
mvn install deploy:deploy-file -DgroupId=io.github.smnpo -DartifactId=%PROJECT% -Dversion=%VERSION% -Dpackaging=pom -Dfile=.\target\%PROJECT%-%VERSION%.pom -Durl=http://maven.develophelper.com/repository/maven-snapshots/ -DrepositoryId=personalsnapshots