set VERSION=1.0-SNAPSHOT
set PROJECT=smnpo-springboot-parent
set URL=https://repo.rdc.aliyun.com/repository/71943-snapshot-gMBvZN/
mvn install deploy:deploy-file -DgroupId=io.github.smnpo -DartifactId=%PROJECT% -Dversion=%VERSION% -Dpackaging=pom -Dfile=.\target\%PROJECT%-%VERSION%.pom -Durl=%URL% -DrepositoryId=rdc-snapshots