<template>
    <div>
        <ul>
            <li v-for="mail in refArr" :key="mail.mno">
               <input type="checkbox" :value="mail.mno" v-model="checkedList"> {{ mail.mno }} -- {{ mail.title }}
            </li>
        </ul>
    </div>
    <div>
        <button @click="handleClick">REMOVE</button>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const props = defineProps(['arr'])

const emits = defineEmits(['removeCB'])

const refArr = ref(props.arr || [])

const checkedList = ref([])

const handleClick = () => {
    console.log(checkedList.value)

    refArr.value = refArr.value.filter(ele => !checkedList?.value.includes(ele.mno))

    emits('removeCB')
}

</script>

<style lang="scss" scoped>

</style>