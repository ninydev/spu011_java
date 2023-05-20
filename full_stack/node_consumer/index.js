// Настройки проекта
const serverName = process.env.NAME || 'Node Consumer';
const port = process.env.PORT || 3000;
const redisSocketHost = process.env.REDIS_SOCKET_HOST || 'redis.socket';
const redisSocketPort = process.env.REDIS_SOCKET_PORT || 6379;
const rabbitQueue = process.env.RABBITMQ_QUEUE || 'test_queue';
const rabbitUser = process.env.RABBITMQ_DEFAULT_USER || 'user';
const rabbitPassword = process.env.RABBITMQ_DEFAULT_PASS || 'password';
const rabbitServer = process.env.RABBITMQ_SERVER || 'rabbit.mq';
const rabbitPort = process.env.RABBITMQ_PORT || 5672;


// Необходимые библиотеки
const { Emitter } = require("@socket.io/redis-emitter");
const { createClient } = require("redis");
const amqp = require("amqplib/callback_api");

// Соединение с Redis - для сообщений
const connect = async () => {
    const redisClient = createClient({  url: `redis://${redisSocketHost}:${redisSocketPort}` });
    redisClient.on("connect", () => {
        console.log("connected");
    });

    // Ожидание соединения
    await redisClient.connect();
    const io = new Emitter(redisClient);



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

                // А тут мы слушаем что нужно сделать
                amqpChannel.consume(rabbitQueue, function(msg) {
                    data = msg.content.toString()
                    console.log(" [x] Received %s", data)
                    io.emit("from-rabbit"  + data)
                }, {
                    noAck: true
                });


            });
        });



};

connect().catch(console.error);
