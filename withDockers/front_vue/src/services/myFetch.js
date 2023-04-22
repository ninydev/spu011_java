import {toast} from "vue3-toastify";
import myLocalStorage from "@/services/myLocalStorage";
import router from "@/router";
import MyLog from "@/services/myLog";

export default function (url, options = {}) {

    // MyFetch --> then(resole => {} ) . catch(reject => {})
    return new Promise((resole, reject) => {

        // Настраиваю параметры запроса
        // url = 'http://localhost/' + url
        // console.log('+ Fetch +')
        // console.log(url)

        // Подключаем в заголовок JWT
        options.headers = {
            'token': myLocalStorage.getItem('token')
        }


        fetch(url, options)
            .then(response => {
                toast("response.status is => " + response.status)
                // Обработка ошибки - страница не найдена
                if(response.status === 404) {
                    throw new Error('Page Not Found')
                }

                // Обрабатываю ответ когда получены данные
                // Значит я получил данные в формате JSON

                if (response.status === 200){
                    try {
                        return response.json()
                    } catch (er) {
                        throw new Error('Json Error')
                    }
                }


                // Обрабатываю успешные ответы
                // Данные успешно созданы (или тело не содержит ответа
                if (
                    response.status === 201 ||
                    response.status === 204
                ){
                    try {
                        return response.json()
                    } catch (er) {
                        throw new Error('Json Error')
                    }
                }

                // Обработаю ошибку 401 Unauthorized
                if(response.status === 401) {
                    router.push('login')
                    throw new Error('Unauthorized')
                }

                // Обработаю ошибку 403 Forbidden
                if(response.status === 403) {
                    throw new Error('Forbidden')
                }

                // Для всех остальных статусов мне нужно сообщить об ошибке
                router.push('error')
                MyLog("Other server response error: ")
                MyLog(response.status)
                throw new Error('Server error: ' + response.status)

            })
            .then(data => {

                toast.success("Api request Ok")
                MyLog("Data: ")
                MyLog(data)

                if (data.success)
                    resole(data.data)
                else {
                    toast.error(data.errors.join(" & "))
                    reject(data.errors)
                }

                // toast.success("Api request Ok")
                // resole(data)
            })
            .catch(err => {
                console.log("Error in module MyFetch")
                console.log(err)
                toast.error(err.message)
                reject(err)
            })
    })

}
