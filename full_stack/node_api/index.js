// Создание сервера
const express = require('express');
const app = express();
const serverName = process.env.NAME || 'Node Api';
const PORT = process.env.PORT || 3000;



// Запустил сервер
app.listen(PORT, () => console.log("Server running at port " + PORT));
