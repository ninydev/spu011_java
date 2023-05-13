// Создание сервера
const express = require('express');
const app = express();
const serverName = process.env.NAME || 'Node Api';
const PORT = process.env.PORT || 3000;


// Связь с сокетом, через Redis
const { Emitter } = require ("@socket.io/redis-emitter");
const { createClient } = require("redis");

const redisClient = createClient({ url: "redis://redis.socket:6379" });

redisClient.connect().then(() => {
    const emitter = new Emitter(redisClient);

    setInterval(() => {
        let d = new Date().toLocaleString()
        console.log('Ping: ' + d)
        emitter.emit("ping", d + " " + serverName)
    }, 5000);
});


// Связь с сервером очередей сообщений RabbitMQ

// let amqpChannel, amqpConnection;
// const queue = 'pv011_queue';
//
// const amqp = require("amqplib/callback_api");
//
// amqp.connect('amqp://user:password@rabbit.mq:5672', function(errorConnect, connection) {
//     if (errorConnect) {
//         console.log(errorConnect)
//         process.exit(-1);
//     }
//     console.log("connect rabbit ok")
//     amqpConnection = connection
//     connection.createChannel(function(errorChannel, channel) {
//         if (errorChannel) {
//             console.log(errorChannel)
//             process.exit(-1);
//         }
//         console.log("create rabbit channel ok")
//         amqpChannel = channel
//
//         amqpChannel.assertQueue(queue, {
//             // durable: false
//         });
//
//         amqpChannel.consume(queue, function(msg) {
//             data = msg.content.toString()
//             // Тут очень долгая операция - например преобразование видео
//             console.log(" [x] Received %s", data)
//             emitter.emit("message "  + data)
//         }, {
//             noAck: true
//         });
//     });
// });



// Запустил сервер
app.listen(PORT, () => console.log("Server running at port " + PORT));
