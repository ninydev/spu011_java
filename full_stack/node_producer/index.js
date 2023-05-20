// Настройки проекта
const serverName = process.env.NAME || 'Node Producer';
const queue = process.env.RABBITMQ_QUEUE || 'test_queue';
const user = process.env.RABBITMQ_DEFAULT_USER || 'user';
const password = process.env.RABBITMQ_DEFAULT_PASS || 'password';
const server = process.env.RABBITMQ_SERVER || 'password';
const port = process.env.RABBITMQ_PORT || 'password';

// Необходимые библиотеки
const amqp = require("amqplib/callback_api");

// Соединение с RabbitMQ - для сообщений
amqp.connect(`amqp://${user}:${password}@${server}:${port}`,
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

        amqpChannel.assertQueue(queue, {
            // durable: false
        });


        setInterval( () => {
            let d = new Date().toLocaleString()
            console.log('Queue: ' + d)
            amqpChannel.sendToQueue(queue, Buffer.from(d));
        }, 5000 )
    });
});

