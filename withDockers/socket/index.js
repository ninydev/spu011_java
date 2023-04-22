const express = require('express');
const app = express();
const server = require('http').createServer(app);
const io = require('socket.io')(server);
const { createAdapter } = require('@socket.io/redis-adapter');
const { createClient } = require('redis');
const port = process.env.PORT || 3000;
const serverName = process.env.NAME || 'Unknown';

const pubClient = createClient({ host: 'redis', port: 6379 });
const subClient = pubClient.duplicate();

io.adapter(createAdapter(pubClient, subClient));

server.listen(port, () => {
  console.log('Server listening at port %d', port);
  console.log('Hello, I\'m %s, how can I help?', serverName);
});

// Chatroom
let socketCount = 0; // Количество открытых соединений на сервере
let socketByUserId = []; // Количество открытых сокетов на пользователя на сервере

// Авторизация
const jwt = require('jsonwebtoken');
const JWT_SECRET=process.env.JWT_SECRET || "uTurgrInrmtmuS91HLRwxO7J4N6tAHvSocoiF3s7w9Ejfxt88NktVActiUbhmY9i"

io.use(function(socket, next){
  if (socket.handshake.query && socket.handshake.query.token){
    console.log(socket.handshake.query.token)
    jwt.verify(socket.handshake.query.token, JWT_SECRET, function(err, user) {
      if (err) return next(); // next(new Error('Authentication error'));
      socket.user = user;
      next();
    });
  }
  else {
    next()
    // next(new Error('Authentication error'));
  }
}).on('connection', socket => {

  socketCount++; // Добавлю количество пользователей на сервере
  console.log("++ Socket count: " + socketCount)
  console.log("new: " + socket.handshake.address )
  // Когда кто то устанавливает соединение с сокетом
  // я отсылаю ему сообщение
  socket.emit('my-name-is', serverName);


  if(socket.user){
    console.log(socket.user)
    socket.broadcast.emit('new-socket-for-user', socket.user.name);
    socket.emit('new-socket-for-user', socket.user.name)
  }


  // when the user disconnects.. perform this
  socket.on('disconnect', () => {
    --socketCount; // Отминусовал пользователя
    console.log("-- socket count: " + socketCount)
  });

});
