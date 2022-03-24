# health_server_Spring_Boot
## 앱 소개

![image](https://user-images.githubusercontent.com/50285234/158755919-add373aa-5b12-4be1-bb3a-b5f3ce40843a.png)

<aside>
💡 로그인 시, 다른 유저 정보가 키와 성별을 표시하고 사용자는 비슷한키와 같은 성별을 클릭하여 다른 유저의 운동 기록과 변화를 파악할 수 있습니다.

</aside>

![image](https://user-images.githubusercontent.com/50285234/158755959-3da6a8e3-aff1-45ee-ba13-8e1d55820afe.png)

<aside>
💡 MY 버튼을 클릭하여 자신의 운동을 기록할 수 있습니다.

</aside>

## 기술 스택

- OS: Windows
- DB: Maria DB
- WAS: Tomcat
- 프레임워크: Spring Boot(Spring Security(JWT), JPA)
- Android Studio: Retrofit을 이용한 http 통신(REST API)

## 프로젝트 구조

- Spring Boot를 이용해 웹 애플리케이션을 만들고 REST 기반 서버를 구축
- DB는 mariadb를 이용해 Spring boot 애플리케이션과 연동
- 안드로이드(Client)에서 db 조회 등의 요청을 Spring 애플리케이션에 보내면 적절한 응답을 Client에게 return

## 기능 소개

- Android와 Spring Boot 웹애플리케이션간의 http 통신(REST API)
- Spring Security와 Jason Web Token을 이용한 사용자 인증 관리
    - 로그인시, 사용자에게 JWT가 발급되며, 이후 Client의 모든 Request는 Header에 Token을 담아 사용자 인증과정을 거친 후 응답을 받습니다.
    - 예시) 로그인시, JWT 발급
    
![image](https://user-images.githubusercontent.com/50285234/158755987-256c615d-c49a-4f9a-b97e-5a85c28f0690.png)
    
- JPA를 이용한 DB접근

## API 명세
![image](https://user-images.githubusercontent.com/50285234/158756019-e96a5d54-b368-465b-9f64-a3b3e4b481b1.png)

