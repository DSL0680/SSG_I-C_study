<template>
    <div>
        <TodoInput @addTodo="addTodo"></TodoInput>
        <TodoList :todoList="todoList" @removeTodos="removeTodos" @modifyTodo="modifyTodo"></TodoList>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import TodoInput from './TodoInput.vue';
import TodoList from './TodoList.vue';
import { v4 as uuidv4 } from 'uuid';

const todoList = ref([])

const addTodo = (todo) => {
    todo.tno = uuidv4()
    todoList.value = [...todoList.value, todo]

    console.log(todoList.value)
}

const removeTodos = (tnos) => {
    todoList.value = todoList.value.filter(todo => !tnos.includes(todo.tno))
}

const modifyTodo = (todo) => {

let targetTodo = todoList.value.find(t => t.tno === todo.tno)
targetTodo = todo

console.log("modified")

}

</script>

<style lang="scss" scoped></style>
