import {toast} from "vue3-toastify";
import myLog from "@/services/myLog";

export default {

    setItem(name, item, ttl = 3600) {
        localStorage.setItem(name, JSON.stringify(item))
        localStorage.setItem(name + '_time', Date.now())
        localStorage.setItem(name + '_ttl', ttl)
    },

    getItem(name){
        if(localStorage.getItem(name)) {
            myLog("Now " + Date.now())
            myLog("time " + localStorage.getItem(name + '_time'))
            myLog(" - " + (Date.now() - localStorage.getItem(name + '_time')))
            myLog("ttl" + localStorage.getItem(name + '_ttl'))
            if(
                Date.now() - localStorage.getItem(name + '_time') >
                localStorage.getItem(name + '_ttl')
            ) {
                localStorage.removeItem(name + '_time')
                localStorage.removeItem(name + '_ttl')
                localStorage.removeItem(name)
            } else {
                try {
                    return JSON.parse(localStorage.getItem(name))
                } catch (ex) {
                    toast.error("Local Storage Error")
                }
            }
        }
        return null
    }
}

