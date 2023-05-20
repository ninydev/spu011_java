// Настройки проекта
const serverName = process.env.NAME || 'Node Producer';
const rabbitQueue = process.env.RABBITMQ_QUEUE || 'test_queue';
const rabbitUser = process.env.RABBITMQ_DEFAULT_USER || 'user';
const rabbitPassword = process.env.RABBITMQ_DEFAULT_PASS || 'password';
const rabbitServer = process.env.RABBITMQ_SERVER || 'rabbit.mq';
const rabbitPort = process.env.RABBITMQ_PORT || 5672;

// Необходимые библиотеки
const amqp = require("amqplib/callback_api");

// Соединение с RabbitMQ - для сообщений
amqp.connect(`amqp://${rabbitUser}:${rabbitPassword}@${rabbitServer}:${rabbitPort}`,
    function(errorConnect, connection) {
    if (errorConnect) {
        console.log(errorConnect)
        process.exit(-1);
    }
    console.log("connect rabbit ok")
    amqpConnection = connection
    connection.createChannel(function(errorChannel, channel) {
        if (errorChannel) {
            console.log(errorChannel)
            process.exit(-1);
        }
        console.log("create rabbit channel ok")
        amqpChannel = channel

        amqpChannel.assertQueue(rabbitQueue, {
            // durable: false
        });


        setInterval( () => {
            let d = new Date().toLocaleString()
            console.log('Queue: ' + d)
            amqpChannel.sendToQueue(rabbitQueue, Buffer.from(d));
        }, 5000 )
    });
});

