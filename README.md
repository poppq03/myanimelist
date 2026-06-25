# 내 애니 기록장

보고 있는 애니 제목, 장르, 화수, 평점, 한줄평을 기록하는 CRUD API입니다.
Java/Spring을 처음 배우면서 만든 프로젝트입니다.

## 기술 스택
Java 21, Spring Boot, Spring Data JPA, H2

## 기능
- 애니 등록/조회/수정/삭제
- 상태별 검색 (`?status=완료`)
- 페이징, 정렬
- 중복 제목 등록 방지
- 평균 평점 통계 (`/animes/stats`)

## 실행
- ./gradlew bootRun
- 실행 후 'localhost:8080/animes' 로 접속