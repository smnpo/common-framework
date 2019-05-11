set VERSION=0.0.1
set PROJECT=smnpo-message-starter
set URL=https://repo.rdc.aliyun.com/repository/71943-release-LWfjuf/
mvn clean install deploy:deploy-file -DgroupId=io.github.smnpo -DartifactId=%PROJECT% -Dversion=%VERSION% -Dpackaging=jar -Dfile=.\target\%PROJECT%-%VERSION%.jar -Durl=%URL% -DrepositoryId=rdc-releases
