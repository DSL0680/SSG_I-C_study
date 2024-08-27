import { defineStore } from "pinia";
import { computed, ref, toRef } from "vue";


const useMember2 = defineStore('useMember2', () => {

    const userId = ref({ mid: '' })

    const toMid = toRef(userId.value, "mid")

    const signin = (str) => {

        userId.value.mid = str
        localStorage.setItem("mid", str)
        console.log(userId)

        

    }

    const signout = () => {
        userId.value.mid = ''
        localStorage.removeItem("mid")
    }

    const computedMid = computed(() => {

        return toMid
    })





    return { userId, signin, signout, computedMid }

})

export default useMember2