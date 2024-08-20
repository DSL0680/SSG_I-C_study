<template>
    <TodoBox :title="'Todo List'">
        <button @click="handleClickRemove">REMOVE</button>
        <ul>
            <li v-for="todo in props.todoList" :key="todo.tno">
                <input type="checkbox" :value="todo.tno" v-model="selectList">{{ todo.title }} -- {{ todo.content }}
            </li>
        </ul>
    </TodoBox>
</template>

<script setup>
import { ref } from 'vue';
import TodoBox from './TodoBox.vue';

const props = defineProps(['todoList'])

const emits = defineEmits(['removeTodos'])

const selectList = ref([])

const handleClickRemove = () => {
    console.log(selectList.value)

    if(selectList.value.length == 0){
        return
    }
    emits('removeTodos', selectList.value)
}


</script>

<style lang="scss" scoped></style>