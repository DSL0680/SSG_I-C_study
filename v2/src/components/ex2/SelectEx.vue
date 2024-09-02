<template>
    <div>
        <ul ref="list">
            <li v-for="{ mno, title } in refArr" :key="mno">
                <input type="checkbox" :value="mno" name="checkList">{{ mno }} --- {{ title }}
            </li>
        </ul>
    </div>
    <div>
        <button @click="handleClick">REMOVE</button>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const list = ref(null)

const props = defineProps(['arr'])

console.log(props.arr)

const refArr = ref(props.arr)

const handleClick = () => {
    console.log("click...")

    const ul = list.value
    const targetArr = Array.from(ul.querySelectorAll("li input[type='checkbox']:checked"))

    console.log(targetArr)
    const mnos = targetArr.map(ele => parseInt(ele.value))

    refArr.value = refArr.value.filter(mail => mnos.includes(mail.mno) === false)

}

</script>

<style lang="scss" scoped></style>