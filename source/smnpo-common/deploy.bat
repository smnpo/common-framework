set VERSION=1.0-SNAPSHOT
set PROJECT=smnpo-common
mvn clean install deploy:deploy-file -DgroupId=io.github.smnpo -DartifactId=%PROJECT% -Dversion=%VERSION% -Dpackaging=jar -Dfile=.\target\%PROJECT%-%VERSION%.jar -Durl=http://maven.develophelper.com/repository/maven-snapshots/ -DrepositoryId=personalsnapshots
