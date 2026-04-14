# 1. 자바 17 환경 사용
FROM openjdk:17-jdk-slim

# 2. 빌드된 실행 파일(jar)의 위치 지정
ARG JAR_FILE=build/libs/*.jar

# 3. 파일을 컨테이너 안으로 복사
COPY ${JAR_FILE} app.jar

# 4. 서버 실행!
ENTRYPOINT ["java", "-jar", "/app.jar"]