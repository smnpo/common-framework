set VERSION=1.0-SNAPSHOT
set PROJECT=smnpo-rocketmq-starter
set URL=https://repo.rdc.aliyun.com/repository/71943-snapshot-gMBvZN/
mvn clean install deploy:deploy-file -DgroupId=io.github.smnpo -DartifactId=%PROJECT% -Dversion=%VERSION% -Dpackaging=jar -Dfile=.\target\%PROJECT%-%VERSION%.jar -Durl=%URL% -DrepositoryId=rdc-snapshots
