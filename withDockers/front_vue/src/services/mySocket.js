import {connect, io} from "socket.io-client"
import {toast} from "vue3-toastify"
import {defineStore} from "pinia";
import MyLocalStorage from "@/services/myLocalStorage";

let mySocket = io('http://localhost', {
    query: {'token': MyLocalStorage.getItem('token')}
})

mySocket.on('my-name-is', (data) => {
    toast.info("connect to: " + data)
})
mySocket.on('mySocket-count', (data) => {
    toast.info("Socket count: " + data)
})
mySocket.on('connect_error', (data) => {
    toast.error("Socket no connect: " + data.message)
})
mySocket.on('message', (data) => {
    toast.success("Message: " + data)
})
mySocket.on('new-socket-for-user', (data) => {
    toast.success("new mySocket for user: " + data)
})

console.log('mySocket module')

export const useSocketService = defineStore('mySocket', {
    stale: () =>{

    },
    actions: {
        reconnect(token) {
            mySocket.disconnect()
            mySocket.io.opts.query = { token: token }
            mySocket.connect()
            toast.dark(token)
        }
    }
})