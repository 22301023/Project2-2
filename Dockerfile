# 1단계: Maven으로 WAR 빌드
FROM maven:3.9 AS build
WORKDIR /app
COPY . .
RUN mvn package -DskipTests

# 2단계: Tomcat 이미지에 WAR 배포
FROM tomcat:9.0
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]