
Deployment link:
https://sea-c.vercel.app/

## Stack yang digunakan
- Java + Spring Boot (Backend)
- Vue + Vite + NPM (Frontend)
- MySQL (Database)
- Maven (Build Tool)
- Git (Control Version)

## Prerequisites
Pastikan Anda telah meng-install:
- Java
- Maven
- MySQL
- Node.js
- Git
- Npm
- Vite 
- Spring boot

Sources of Assets:
- Menu 1: https://id.pinterest.com/pin/30540103719598657/
- Menu 2: https://id.pinterest.com/pin/351912461325036/
- Menu 3: https://id.pinterest.com/pin/12736811442325735/

Library Used:
- https://github.com/ismail9k/vue3-carousel (Carousel)
- https://github.com/mascii/vue-yup-form (Yup)



## Instalasi

1. Clone this repository:
   ```sh
   git clone https://github.com/AufaSatriatama/SEA-C.git
   cd SEA-Compfest
   ```

2. Create new database:
    ```sh
    mysql -u root -p
    [Masukkan password MySQL Anda]
    CREATE DATABASE [Nama database Anda];
    ```

3. Create and edit .env file at /Springboot-SEA-C

3. Change Spring Boot configuration

    - Masuk ke SEA-Compfest\Springboot-SEA-C\src\main\resources
    - Ubah konfigurasi di application.properties sesuai username, password, dan database MySQL Anda

4. Run Backend
    ```sh
    cd Springboot-SEA-C
    mvn clean install
    mvn spring-boot:run
    ```

    Backend will run at localhost:8080

5. Install frontend dependencies

    ```sh
    cd ..
    npm install
    ```

6. Run Frontend
    ```sh
    npm run dev
    ```

    Frontend will run at localhost:5173





