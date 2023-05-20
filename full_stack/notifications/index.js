// Настройки проекта
const serverName = process.env.NAME || 'Node Notifications';
const port = process.env.PORT || 3000;
const redisSocketHost = process.env.REDIS_SOCKET_HOST || 'redis.socket';
const redisSocketPort = process.env.REDIS_SOCKET_PORT || 6379;
const OPENAI_API_KEY = process.env.OPENAI_API_KEY || null;

// Необходимые библиотеки
const { Emitter } = require("@socket.io/redis-emitter");
const { createClient } = require("redis");
const axios = require('axios');

// Соединение с Redis - для сообщений
const connect = async () => {
    const redisClient = createClient({  url: `redis://${redisSocketHost}:${redisSocketPort}` });
    redisClient.on("connect", () => {
        console.log("connected");
    });

    // Ожидание соединения
    await redisClient.connect();
    const io = new Emitter(redisClient);

    // Пример сообщения - шлем просто дату
    setInterval(() => {
        let d = new Date().toLocaleString()
        io.emit("ping", d + " " + serverName)
    }, 30000);

    // Работаем с чатиком
    /*
    setInterval(async () => {
        let d = new Date().toLocaleString()

        const options = {
            method: 'POST',
            url: 'https://api.openai.com/v1/completions',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${OPENAI_API_KEY}`, // Здесь нужно указать свой API ключ
            },
            data: {
                "model": "text-davinci-003",
                "prompt": "Скажи случайную фразу про микросервесные технологии, на русском языке",
                "max_tokens": 256,
                "temperature": 1,
                "top_p": 1,
                "n": 1,
                "stream": false,
            },
        };

        const response = await axios(options);
        const msg = response.data.choices[0].text.trim()

        console.log(msg)

        io.emit("chat-gpt", {data: d, message: msg})
    }, 30000);
     */
};

connect().catch(console.error);
