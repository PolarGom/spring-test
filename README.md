Spring Testing Study
=========
 
* [1. Spring Testing 간략 정리](https://github.com/PolarGom/spring-test/wiki)
* [2. 프로젝트 정보](#프로젝트-정보)
* [3. Application.yml](#application.yml)
* [4. H2 Database 콘솔](#h2-database-콘솔)
* [5. 프로젝트 파일 설명](#프로젝트-파일-설명)

-------------
### 프로젝트 정보
- Spring Boot 2.4.1
- Gradle 5.6.4
- JUnit 5
- H2 Database

### application.yml
- jpa 설정
  - ddl-auto: 데이터베이스 초기화 전략(none, create-drop, update, create, validate)
  - use-new-id-generator-mapping: @GeneratedValue 값을 AUTO 할 경우 Spring 1.5 버전에서는 IDENTITY를 따라가고 Spring 2.0 버전에서는 TABLE을 따라감
  - physical-strategy: 변수이름을 컬럼으로 사용
  - generate-ddl: 데이터베이스 자동 초기화 유무
  - show-sql: Hibernate 가 DB에 날린 쿼리를 보여줌
  - format_sql: 쿼리를 포맷팅 해줌
  - enable_lazy_load_no_trans: Lazy Load 적용
- h2 Database 설정
  - enabled: h2 DB console 사용 유무
  - path: h2 DB console 접근 경로
- datasource 설정
  - url: h2 DB jdbc url
  - username: DB 사용자 이름
  - password: DB 사용자 비밀번호
  - driver-class-name: DB 드라이버
- server 설정
  - port: 접근 포트(예. localhost:9090)
  - context-path: 웹 어플리케이션 구분하기 위한 Path(예. localhost:9090/test)
- logging 설정
  - config: 로그 설정 파일 경로

### h2 database 콘솔
1. application.yml 에서 h2 enabled가 true 이고 path 확인

```
 h2:
    console:
      enabled: true
      path: /h2-console
```

2. 설정한 포트 및 컨텍스트 패스 및 H2 path 를 브라우저 주소창에 입력(예. localhost:9090/h2-console)

3. H2 데이터베이스 로그인 콘솔창이 뜨게 되는데 Servered Setting의 셀렉트박스르 선택하여 Generic H2(Server) 로 변경

4. JDBC URL 입력 부분을 application.yml에서 설정한 datasource.url 을 입력

```
  datasource:
    url: jdbc:h2:mem:testdb;
```

5. 아래의 connect 버튼을 클릭하면 브라우저에서 DB를 확인 할 수 있다.

### 프로젝트 파일 설명
- src/main/resources
  - schema.sql: DB 스키마 정의 파일
  - import.sql: DB Insert 문 정의 파일
  - logback: 로그 설정 폴더
    - logback-spring.xml: 로그 설정 파일