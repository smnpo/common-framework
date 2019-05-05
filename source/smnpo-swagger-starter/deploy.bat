set VERSION=1.0-SNAPSHOT
set PROJECT=smnpo-swagger-starter
"D:\Program Files\JetBrains\IntelliJ IDEA 2018.1.6\plugins\maven\lib\maven3\bin\mvn" clean install deploy:deploy-file -DgroupId=io.github.smnpo -DartifactId=%PROJECT% -Dversion=%VERSION% -Dpackaging=jar -Dfile=.\target\%PROJECT%-%VERSION%.jar -Durl=http://maven.develophelper.com/repository/maven-snapshots/ -DrepositoryId=personalsnapshots