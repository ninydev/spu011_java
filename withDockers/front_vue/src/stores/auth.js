import {defineStore} from "pinia";
import myFetch from "@/services/myFetch";
import myLocalStorage from "@/services/myLocalStorage";
import {useSocketService} from "@/services/mySocket";
import {toast} from "vue3-toastify";


export const useAuthStore = defineStore('auth', {
   state: () => ({
       isAuth: false, // пользователь вошел в систему
       isProcessing: false, // происходит обработка запроса
       token: null, // ключ, полученный от сервера
       user: null
   }),
    actions: {
       apiLogin() {
           this.isProcessing = true
           myFetch('/api/auth/login', {
               method: "POST",
           })
               .then( data => {
                   this.token = data.token
                   myLocalStorage.setItem('token', data.token)
                   this.user = data.user
                   this.isProcessing = false
                   this.isAuth = true
                   // Получаем экземпляр mySocket
                   const mySocket = useSocketService();

                   // Вызываем метод reconnect() из mySocket
                   mySocket.reconnect(this.token);

               })
       }
    }

});
