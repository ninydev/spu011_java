// Создание сервера
const express = require('express');
const app = express();
const serverName = process.env.NAME || 'Nodejs JWT Auth';
const PORT = process.env.PORT || 3000;

// Подключение библиотек для шифрования
jwt = require('jsonwebtoken')
const JWT_SECRET=process.env.JWT_SECRET || "uTurgrInrmtmuS91HLRwxO7J4N6tAHvSocoiF3s7w9Ejfxt88NktVActiUbhmY9i"


// Маршрут который отдает нам ключ
app.post("/api/auth/login", (request, response) => {

    // Данные о пользователе, которые я получил например из базы
    let user = {
        "id": 10,
        "name": "Oleksandr Nykytin",
        "email": "keeper@ninydev.com",
        "roles": [
            {
                "id": 1,
                "name": "user"
            },
            {
                "id": 2,
                "name": "admin"
            }
        ]
    }

    let token = jwt.sign(
        user,
        JWT_SECRET
    )


    response.status(200).json({
        "success" : true,
        "data" : {
            "user": user,
            "token": token,
            "message": "Welcome"
        },
        errors: []
    })
});


// Запустил сервер
app.listen(PORT, () => console.log("Server " + serverName + " running at port " + PORT));
