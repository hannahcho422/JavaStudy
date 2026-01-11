# 실행용 기반 이미지
FROM eclipse-temurin:21

# 작업 디렉터리
WORKDIR /app

# 빌드된 jar 복사 
COPY build/libs/demo_board-0.0.1-SNAPSHOT.jar app.jar

# 문서상 포트 표시
EXPOSE 8080

# 컨테이너 "고정 실행 파일" 
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
