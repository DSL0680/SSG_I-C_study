<template>
    <TodoBox :title="'Input New Todo'">
        <input type="text" v-model="todoRef.title">
        <input type="text" v-model="todoRef.content">
        <button @click="handleClick">ADD</button>
    </TodoBox>
</template>

<script setup>
import { ref } from 'vue';
import TodoBox from './TodoBox.vue';

const initState = {title:'', content:''}

const emits = defineEmits(['addTodo'])

const todoRef = ref({...initState})

const handleClick = () => {
    console.log(todoRef.value)

    const todoParam = {
        title: todoRef.value.title,
        content: todoRef.value.content
    }
    emits('addTodo', todoParam)

    todoRef.value = {...initState}
}

</script>

<style lang="scss" scoped>

</style>