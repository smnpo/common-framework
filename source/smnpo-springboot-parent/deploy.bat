set VERSION=0.0.1
set PROJECT=smnpo-springboot-parent
set URL=https://repo.rdc.aliyun.com/repository/71943-release-LWfjuf/
mvn install deploy:deploy-file -DgroupId=io.github.smnpo -DartifactId=%PROJECT% -Dversion=%VERSION% -Dpackaging=pom -Dfile=.\target\%PROJECT%-%VERSION%.pom -Durl=%URL% -DrepositoryId=rdc-releases