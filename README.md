# health_server_Spring_Boot
## ์ฑ ์๊ฐ

![image](https://user-images.githubusercontent.com/50285234/158755919-add373aa-5b12-4be1-bb3a-b5f3ce40843a.png)

<aside>
๐ก ๋ก๊ทธ์ธ ์, ๋ค๋ฅธ ์ ์  ์ ๋ณด๊ฐ ํค์ ์ฑ๋ณ์ ํ์ํ๊ณ  ์ฌ์ฉ์๋ ๋น์ทํํค์ ๊ฐ์ ์ฑ๋ณ์ ํด๋ฆญํ์ฌ ๋ค๋ฅธ ์ ์ ์ ์ด๋ ๊ธฐ๋ก๊ณผ ๋ณํ๋ฅผ ํ์ํ  ์ ์์ต๋๋ค.

</aside>

![image](https://user-images.githubusercontent.com/50285234/158755959-3da6a8e3-aff1-45ee-ba13-8e1d55820afe.png)

<aside>
๐ก MY ๋ฒํผ์ ํด๋ฆญํ์ฌ ์์ ์ ์ด๋์ ๊ธฐ๋กํ  ์ ์์ต๋๋ค.

</aside>

## ๊ธฐ์  ์คํ

- OS: Windows
- DB: Maria DB
- WAS: Tomcat
- ํ๋ ์์ํฌ: Spring Boot(Spring Security(JWT), JPA)
- Android Studio: Retrofit์ ์ด์ฉํ http ํต์ (REST API)

## ํ๋ก์ ํธ ๊ตฌ์กฐ

- Spring Boot๋ฅผ ์ด์ฉํด ์น ์ ํ๋ฆฌ์ผ์ด์์ ๋ง๋ค๊ณ  REST ๊ธฐ๋ฐ ์๋ฒ๋ฅผ ๊ตฌ์ถ
- DB๋ mariadb๋ฅผ ์ด์ฉํด Spring boot ์ ํ๋ฆฌ์ผ์ด์๊ณผ ์ฐ๋
- ์๋๋ก์ด๋(Client)์์ db ์กฐํ ๋ฑ์ ์์ฒญ์ Spring ์ ํ๋ฆฌ์ผ์ด์์ ๋ณด๋ด๋ฉด ์ ์ ํ ์๋ต์ Client์๊ฒ return

## ๊ธฐ๋ฅ ์๊ฐ

- Android์ Spring Boot ์น์ ํ๋ฆฌ์ผ์ด์๊ฐ์ http ํต์ (REST API)
- Spring Security์ Jason Web Token์ ์ด์ฉํ ์ฌ์ฉ์ ์ธ์ฆ ๊ด๋ฆฌ
    - ๋ก๊ทธ์ธ์, ์ฌ์ฉ์์๊ฒ JWT๊ฐ ๋ฐ๊ธ๋๋ฉฐ, ์ดํ Client์ ๋ชจ๋  Request๋ Header์ Token์ ๋ด์ ์ฌ์ฉ์ ์ธ์ฆ๊ณผ์ ์ ๊ฑฐ์น ํ ์๋ต์ ๋ฐ์ต๋๋ค.
    - ์์) ๋ก๊ทธ์ธ์, JWT ๋ฐ๊ธ
    
![image](https://user-images.githubusercontent.com/50285234/158755987-256c615d-c49a-4f9a-b97e-5a85c28f0690.png)
    
- JPA๋ฅผ ์ด์ฉํ DB์ ๊ทผ

## API ๋ช์ธ
![image](https://user-images.githubusercontent.com/50285234/158756019-e96a5d54-b368-465b-9f64-a3b3e4b481b1.png)

